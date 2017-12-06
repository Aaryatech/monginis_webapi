package com.ats.webapi.service.rawmaterial;

import java.util.List;

import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;

public interface ItemSfService {
	
	public ItemSfHeader saveHeader(ItemSfHeader itemSfHeader);
	
	//public ItemSfDetail saveDetail(List<ItemSfDetail> itemSfDetail);

}
