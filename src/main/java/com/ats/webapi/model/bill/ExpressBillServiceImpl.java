package com.ats.webapi.model.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillDetailList;
import com.ats.webapi.model.SellBillDetails;
import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.repository.ExpressBillRepository;
import com.ats.webapi.repository.SellBillDetailRepository;
import com.ats.webapi.repository.SellBillDetailsRepository;

@Service
public class ExpressBillServiceImpl implements ExpressBillService{

	@Autowired
	ExpressBillRepository  expressBillRepository  ;
	
	@Autowired
	SellBillDetailRepository sellBillDetailRepository;
	
	@Autowired
	SellBillDetailsRepository sellBillDetailsRepository;

	
	@Override
	public SellBillDataCommon showNotDayClosedRecord(int frId) {
		SellBillDataCommon sellBillDataCommon=new SellBillDataCommon();

		List<SellBillHeader> sellBillHeaderList=expressBillRepository.findByBillTypeAndGrandTotalAndFrId('E',0f,frId);
		
		
		if(sellBillHeaderList!=null)
		{
			sellBillDataCommon.setSellBillHeaderList(sellBillHeaderList);
		}
		else
		{
			sellBillDataCommon.setSellBillHeaderList(sellBillHeaderList);

		}
		return sellBillDataCommon;
	}

	@Override
	public SellBillDetailList getSellBillDetails(int billNo) {

		SellBillDetailList sellBillDetailList=new SellBillDetailList();
		ErrorMessage errorMessage=new ErrorMessage();
		
		List<SellBillDetails> sellBillDetails=sellBillDetailsRepository.findByBillNo(billNo);

		if(sellBillDetails!=null)
		{
			sellBillDetailList.setSellBillDetailList(sellBillDetails);
			sellBillDetailList.setErrorMessage(errorMessage);
		}
		else
		{
			sellBillDetailList.setErrorMessage(errorMessage);

		}
		return sellBillDetailList;
	}

	@Override
	public SellBillHeader saveSellBillHeader(SellBillHeader sellBillHeader) {

		SellBillHeader sellBillHeaderRes=expressBillRepository.save(sellBillHeader);
		
		return sellBillHeaderRes;
	}

	@Override
	public SellBillDetail saveSellBillDetail(SellBillDetail sellBillDetail) {

		SellBillDetail sellBillDetailRes=sellBillDetailRepository.save(sellBillDetail);
		
		return sellBillDetailRes;
	}

	@Override
	public SellBillHeader getSellBillHeaderBysellBillNo(int sellBillNo) {
		
		SellBillHeader sellBillHeader=null;
		
		try {
			
				sellBillHeader=expressBillRepository.getBysellBillNo(sellBillNo);
		 
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println("Exception in getting sell Bill Header for Day Close " +e.getMessage());
		}
		
	return sellBillHeader;
	
	
	}

	

}
