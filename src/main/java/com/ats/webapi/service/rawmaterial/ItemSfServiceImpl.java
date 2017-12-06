package com.ats.webapi.service.rawmaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.repository.ItemSfDetailRepo;
import com.ats.webapi.repository.ItemSfHeaderRepo;

@Service
public class ItemSfServiceImpl implements ItemSfService {

	@Autowired
	ItemSfHeaderRepo itemSfHeaderRepo;

	@Autowired
	ItemSfDetailRepo itemSfDetailRepo;

	@Override
	public ItemSfHeader saveHeader(ItemSfHeader itemSfHeader) {
		ItemSfHeader itemHeader = null;
		try {

			itemHeader = itemSfHeaderRepo.save(itemSfHeader);

			for (int i = 0; i < itemSfHeader.getItemSfDetail().size(); i++) {

				ItemSfDetail itemDetail = itemSfHeader.getItemSfDetail().get(i);

				itemDetail.setSfId(itemSfHeader.getSfId());

				ItemSfDetail detail = itemSfDetailRepo.save(itemDetail);

			}
		} catch (Exception e) {
			
			System.out.println("Exce in itemSf insert service "+e.getMessage());
			e.printStackTrace();
			
		}
		return itemHeader;
	}

}
