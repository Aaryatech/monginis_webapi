package com.ats.webapi.service.rawmaterial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.rawmaterial.GetItemSfHeader;
import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.repository.ItemSfDetailRepo;
import com.ats.webapi.repository.ItemSfHeaderRepo;
import com.ats.webapi.repository.ItemSfHeaderRepository;

@Service
public class ItemSfServiceImpl implements ItemSfService {

	@Autowired
	ItemSfHeaderRepo itemSfHeaderRepo;

	@Autowired
	ItemSfDetailRepo itemSfDetailRepo;
	
	@Autowired
	ItemSfHeaderRepository itemSfHeaderRepository;

	@Override
	public ItemSfHeader saveHeader(ItemSfHeader itemSfHeader) {
		ItemSfHeader itemHeader = null;
		try {

			itemHeader = itemSfHeaderRepo.save(itemSfHeader);

		} catch (Exception e) {
			
			System.out.println("Exce in itemSf insert service "+e.getMessage());
			e.printStackTrace();
			
		}
		return itemHeader;
	}

	@Override
	public Info saveDetail(List<ItemSfDetail> itemSfDetailList) {
		
		ItemSfDetail itemSfDetail=new ItemSfDetail();
		Info info=new Info();
		
		float sfWeight=0.0f;
		
		for(int i=0;i<itemSfDetailList.size();i++) {
			
			 itemSfDetail=itemSfDetailRepo.save(itemSfDetailList.get(i));
			 sfWeight+=itemSfDetailList.get(i).getRmWeight();
		}
		if(sfWeight>0)
		{
		int isUpdated=itemSfHeaderRepo.updateRmWeightInHeader(itemSfDetailList.get(0).getSfId(),sfWeight);
		}
		if(itemSfDetail!=null) {
			
			info.setError(false);
			info.setMessage("success");
		}
		else {
			
			info.setError(true);
			info.setMessage("failed");
		}
		
	return info;
	
	}

	@Override
	public List<GetItemSfHeader> getItemSfHeaders(int delStatus) {
		
		List<GetItemSfHeader> headerList=itemSfHeaderRepository.getSfItemHeader(delStatus);
		
		return headerList;
	}

	

}
