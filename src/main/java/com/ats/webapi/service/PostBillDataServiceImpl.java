package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.model.PostBillHeader;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.PostBillDetailRepository;
import com.ats.webapi.repository.PostBillHeaderRepository;
import com.ats.webapi.repository.RegularSpCkOrderRepository;
import com.ats.webapi.repository.SpCakeOrdersRepository;

@Service
public class PostBillDataServiceImpl implements PostBillDataService {

	@Autowired
	PostBillHeaderRepository postBillHeaderRepository;

	@Autowired
	PostBillDetailRepository postBillDetailRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	SpCakeOrdersRepository spCakeOrdersRepository;
	
	@Autowired
	RegularSpCkOrderRepository  regularSpCkOrderRepository;
	/*
	 * @Override public List<PostBillDetail> saveBillDetails(List<PostBillDetail>
	 * postBillDetail) {
	 * 
	 * List<PostBillDetail> billDetail=new ArrayList<PostBillDetail>();
	 * for(PostBillDetail pBDetails:postBillDetail) {
	 * 
	 * billDetail=postBillDataService.saveBillDetails(postBillDetail);
	 * 
	 * }
	 * 
	 * return billDetail; }
	 */

	@Override
	public List<PostBillHeader> saveBillHeader(List<PostBillHeader> postBillHeader) {

		List<PostBillHeader> postBillHeaders = new ArrayList<PostBillHeader>();
		for (int i = 0; i < postBillHeader.size(); i++) {

			postBillHeaders = postBillHeaderRepository.save(postBillHeader);

			int billNo = postBillHeader.get(i).getBillNo();

			List<PostBillDetail> postBillDetailList = postBillHeader.get(i).getPostBillDetailsList();

			for (int j = 0; j < postBillDetailList.size(); j++) {

				PostBillDetail billDetail = postBillDetailList.get(j);

				billDetail.setBillNo(billNo);

				postBillDetailRepository.save(billDetail);
				
				int res=0;
				if (billDetail.getCatId() != 5) { 
					
					if(billDetail.getMenuId()!= 42) {//item
						
					 res = orderRepository.updateBillStatus(billDetail.getOrderId(), 1);
					
					}else { // regular sp cake
						regularSpCkOrderRepository.updateRegSpCakeBillStatus(billDetail.getOrderId(), 1);
					}
					
				} else if (billDetail.getCatId() == 5){ //special cake
					 res = spCakeOrdersRepository.updateSpBillStatus(billDetail.getOrderId(), 1);
				}
				
				
				
				System.out.println("Result set for" + billDetail.getOrderId() + " status " + res);

			}
			// postBillDetail.get(i).setBillNo(billNo);
			// postBillDetailRepository.save(postBillDetail);

		}

		return postBillHeaders;
	}

}
