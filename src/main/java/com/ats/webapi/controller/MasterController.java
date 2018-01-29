package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.FrListForSupp;
import com.ats.webapi.model.FrTarget;
import com.ats.webapi.model.FrTargetList;
import com.ats.webapi.model.FrTotalSale;
import com.ats.webapi.model.FranchiseSup;
import com.ats.webapi.model.FranchiseSupList;
import com.ats.webapi.model.GetItemSup;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.ItemSupList;
import com.ats.webapi.model.tray.TrayType;
import com.ats.webapi.repository.FrListForSuppRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.SpCkDeleteOrderRepository;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.OrderService;
import com.ats.webapi.service.RegularSpCkOrderService;
  
@RestController
public class MasterController {

	@Autowired
	ItemService itemService;
	@Autowired
	FranchiseeService franchiseeService;
	
	@Autowired
	RegularSpCkOrderService regularSpCkOrderService;
	
	@Autowired
	FranchiseeRepository franchiseeRepository;
	
	@Autowired
	SpCkDeleteOrderRepository spCkDeleteOrderRepository;
	@Autowired
	FrListForSuppRepository frListForSuppRepository;
	
	// ----------------------------SAVE Item Sup---------------------------
		@RequestMapping(value = { "/saveItemSup" }, method = RequestMethod.POST)
		public @ResponseBody Info saveItemSup(@RequestBody ItemSup itemSup) {

			ItemSup itemSupRes = null;
			Info info = new Info();
			try {

				itemSupRes = itemService.saveItemSup(itemSup);

				if (itemSupRes != null) {
					info.setError(false);
					info.setMessage("ItemSup Saved Successfully.");
				} else {
					info.setError(true);
					info.setMessage("ItemSup Not Saved .");
				}

			} catch (Exception e) {

				info.setError(true);
				info.setMessage("ItemSup Not Saved .");

				e.printStackTrace();
				System.out.println("Exception In MasterController /saveItemSup" + e.getMessage());

			}
			return info;

		}
      //---------------------------------------------------------------------------
		// ------------------------Delete ItemSup------------------------------------
		@RequestMapping(value = { "/deleteItemSup" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteItemSup(@RequestParam("id") int itemId) {

			Info info = itemService.deleteItemSup(itemId);
			return info;
		}
        //------------------------------------------------------------------------
		// ---------------------------Getting ItemSup List-----------------------
		@RequestMapping(value = { "/getItemSupList" }, method = RequestMethod.GET)
		public @ResponseBody ItemSupList getItemSupList() {

			ItemSupList itemSupList = itemService.getItemSupList();

			return itemSupList;

		}
		//------------------------------------------------------------------------
		// ------------------------Getting One ItemSup by Id-----------------------
		@RequestMapping(value = { "/getItemSup" }, method = RequestMethod.POST)
		public @ResponseBody GetItemSup getItemSup(@RequestParam("id") int id) {

			GetItemSup getItemSupRes = null;
			try {
				getItemSupRes = itemService.getItemSup(id);

				if (getItemSupRes != null) {
					getItemSupRes.setError(false);
					getItemSupRes.setMessage("ItemSup Found Successfully");
				} else {
					getItemSupRes = new GetItemSup();
					getItemSupRes.setError(true);
					getItemSupRes.setMessage("ItemSup Not Found");
				}
			} catch (Exception e) {
				getItemSupRes = new GetItemSup();
				getItemSupRes.setError(true);
				getItemSupRes.setMessage("ItemSup Not Found");
				System.out.println("Exception In getItemSup:" + e.getMessage());
			}

			return getItemSupRes;

		}

	// ----------------------------SAVE FranchiseSup---------------------------
		@RequestMapping(value = { "/saveFranchiseSup" }, method = RequestMethod.POST)
		public @ResponseBody Info saveFranchiseSup(@RequestBody FranchiseSup franchiseSup) {

			FranchiseSup franchiseSupRes = null;
			Info info = new Info();
			try {

				franchiseSupRes = franchiseeService.saveFranchiseSup(franchiseSup);

				if (franchiseSupRes != null) {
					info.setError(false);
					info.setMessage("FranchiseSup Saved Successfully.");
				} else {
					info.setError(true);
					info.setMessage("FranchiseSup Not Saved .");
				}

			} catch (Exception e) {

				info.setError(true);
				info.setMessage("FranchiseSup Not Saved .");

				e.printStackTrace();
				System.out.println("Exception In MasterController /saveFranchiseSup" + e.getMessage());

			}
			return info;

		}
      //---------------------------------------------------------------------------
	// ------------------------Delete FranchiseSup------------------------------------
				@RequestMapping(value = { "/deleteFranchiseSup" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteFranchiseSup(@RequestParam int frId) {

					Info info = franchiseeService.deleteFranchiseSup(frId);
					return info;
				}
	 //------------------------------------------------------------------------
	// ---------------------------Getting FranchiseSup List-----------------------
				@RequestMapping(value = { "/getFranchiseSupList" }, method = RequestMethod.GET)
				public @ResponseBody FranchiseSupList getFranchiseSupList() {

					FranchiseSupList franchiseSupList = franchiseeService.getFranchiseSupList();

					return franchiseSupList;

				}
	//------------------------------------------------------------------------	
		// ------------------------Getting One FranchiseSup by Id-----------------------
				@RequestMapping(value = { "/getFranchiseSup" }, method = RequestMethod.POST)
				public @ResponseBody FranchiseSup getFranchiseSup(@RequestParam("id") int id) {

					FranchiseSup getFranchiseSupRes = null;
					try {
						getFranchiseSupRes = franchiseeService.getFranchiseSup(id);

						if (getFranchiseSupRes != null) {
							getFranchiseSupRes.setError(false);
							getFranchiseSupRes.setMessage("FranchiseSup Found Successfully");
						} else {
							getFranchiseSupRes = new FranchiseSup();
							getFranchiseSupRes.setError(true);
							getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						}
					} catch (Exception e) {
						getFranchiseSupRes = new FranchiseSup();
						getFranchiseSupRes.setError(true);
						getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						System.out.println("Exception In getFranchiseSup:" + e.getMessage());
					}

					return getFranchiseSupRes;

				}
				// ----------------------------SAVE FranchiseSup---------------------------
				@RequestMapping(value = { "/saveFrTarget" }, method = RequestMethod.POST)
				public @ResponseBody Info saveFrTarget(@RequestBody List<FrTarget> frTargetList) {

					Info	info = franchiseeService.saveFrTarget(frTargetList);

					return info;

				}
		      //---------------------------------------------------------------------------	
				// ---------------------------Getting FrTarget List-----------------------
				@RequestMapping(value = { "/getFrTargetList" }, method = RequestMethod.POST)
				public @ResponseBody FrTargetList getFrTargetList(@RequestParam("frId")int frId,@RequestParam("year")int year) {

					FrTargetList frTargetList = franchiseeService.getFrTargetList(frId,year);

					return frTargetList;

				}
	        //------------------------------------------------------------------------		
				// ---------------------------Getting TotalFrSale List-----------------------
				@RequestMapping(value = { "/getFrTotalSale" }, method = RequestMethod.POST)
				public @ResponseBody FrTotalSale getFrTotalSale(@RequestParam("frId")int frId,@RequestParam("month")int month,@RequestParam("year")int year) {

					System.out.println("frId"+frId);
					FrTotalSale frTotalSale = franchiseeService.getFrTargetList(frId,month,year);

					return frTotalSale; 

				}
	        //------------------------------------------------------------------------		
				// --------------------------------Update Fr Admin password------------------
				@RequestMapping(value = { "/updateAdminPwd" }, method = RequestMethod.POST)
				public @ResponseBody Info updateAdminPwd(@RequestParam("frId")int frId,@RequestParam("adminPwd")String adminPwd) {

					Info info = franchiseeService.updateAdminPwd(frId,adminPwd);

					return info; 

				}
	        //------------------------------------------------------------------------			
				// ------------------------Update FranchiseSup Passwords------------------------------------
				@RequestMapping(value = { "/updateFranchiseSupUsrPwd" }, method = RequestMethod.POST)
				public @ResponseBody Info updateFranchiseUsrPwd(@RequestParam int frId,@RequestParam String pass1,@RequestParam String pass2,@RequestParam String pass3) {

					Info info = franchiseeService.updateFranchiseSupUsrPwd(frId,pass1,pass2,pass3);
					return info;
				}
	 //------------------------------------------------------------------------				
				// ------------------------Getting One FranchiseSup by Id-----------------------
				@RequestMapping(value = { "/getFrSupByFrId" }, method = RequestMethod.POST)
				public @ResponseBody FranchiseSup getFrSupByFrId(@RequestParam("frId") int frId) {

					FranchiseSup getFranchiseSupRes = null;
					try {
						getFranchiseSupRes = franchiseeService.getFrSupByFrId(frId);

						if (getFranchiseSupRes != null) {
							getFranchiseSupRes.setError(false);
							getFranchiseSupRes.setMessage("FranchiseSup Found Successfully");
						} else {
							getFranchiseSupRes = new FranchiseSup();
							getFranchiseSupRes.setError(true);
							getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						}
					} catch (Exception e) {
						getFranchiseSupRes = new FranchiseSup();
						getFranchiseSupRes.setError(true);
						getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						System.out.println("Exception In getFranchiseSup:" + e.getMessage());
					}

					return getFranchiseSupRes;

				}		
				// ---------------------------Getting Franchise List For Supplement-----------------------
				@RequestMapping(value = { "/getFrListForSupp" }, method = RequestMethod.GET)
				public @ResponseBody List<FrListForSupp> getFrListForSupp() {

					List<FrListForSupp> franchiseSupList = frListForSuppRepository.getFrListForSupp();

					return franchiseSupList;

				}
	              //------------------------------------------------------------------------	
				// ------------------------Delete RegularSpOrder------------------------------------
				@RequestMapping(value = { "/deleteRegularSpOrder" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteRegularSpOrder(@RequestParam int rspId) {

					Info info = regularSpCkOrderService.deleteRegularSpOrder(rspId);
					return info;
				}
	          //------------------------------------------------------------------------
				// ------------------------DeleteSpCkOrder------------------------------------
				@RequestMapping(value = { "/deleteSpCkOrder" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteSpCkOrder(@RequestParam int spOrderNo) {

					int isDeleted =spCkDeleteOrderRepository.deleteSpCkOrder(spOrderNo);
					Info info=new Info();
					if(isDeleted==1)
					{
						info.setError(false);
						info.setMessage("SpCkOrder Deleted");
					}
					else
					{
						info.setError(true);
						info.setMessage("SpCkOrder Deletion Failed");
					}
					return info;
				}
	          //------------------------------------------------------------------------	
				// ------------------------Get Unique Franchise Code------------------------------------
				@RequestMapping(value = { "/getUnigueFrCode" }, method = RequestMethod.GET)
				public @ResponseBody Integer getUnigueFrCode() {

					int maxId =franchiseeRepository.getUnigueFrCode();
					
					return maxId;
				}
	          //------------------------------------------------------------------------
				// ------------------------Get Unique Item Code------------------------------------
				@RequestMapping(value = { "/getUniqueItemCode" }, method = RequestMethod.GET)
				public @ResponseBody Integer getUniqueItemCode() {

					int maxId =itemService.getUniqueItemCode();
					
					return maxId;
				}
	          //------------------------------------------------------------------------
				// ------------------------Get TrayTypes------------------------------------
				@RequestMapping(value = { "/getTrayTypes" }, method = RequestMethod.GET)
				public @ResponseBody List<TrayType> getTrayTypes() {

					List<TrayType> trayTypes =itemService.getTrayTypes();
					
					return trayTypes;
				}
	          //------------------------------------------------------------------------
				
}
