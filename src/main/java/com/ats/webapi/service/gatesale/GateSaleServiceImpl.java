package com.ats.webapi.service.gatesale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.gatesale.GateEmployee;
import com.ats.webapi.model.gatesale.GateSaleBillDetail;
import com.ats.webapi.model.gatesale.GateSaleBillDetailRes;
import com.ats.webapi.model.gatesale.GateSaleBillHeader;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;
import com.ats.webapi.model.gatesale.GateSaleDiscList;
import com.ats.webapi.model.gatesale.GateSaleDiscount;
import com.ats.webapi.model.gatesale.GateSaleUser;
import com.ats.webapi.model.gatesale.GateSaleUserList;
import com.ats.webapi.model.gatesale.GetGateSaleEmp;
import com.ats.webapi.model.gatesale.GetGateSaleEmpList;
import com.ats.webapi.model.gatesale.GetGateSaleUser;
import com.ats.webapi.repository.gatesale.GateEmployeeRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillDetailRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillDetailResRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillHeaderRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillHeaderResRepository;
import com.ats.webapi.repository.gatesale.GateSaleDiscountRepository;
import com.ats.webapi.repository.gatesale.GateSaleRepository;
import com.ats.webapi.repository.gatesale.GateSaleUserListRepository;
import com.ats.webapi.repository.gatesale.GetGateEmployeeRepository;
@Service
public class GateSaleServiceImpl implements GateSaleService{

	@Autowired
	GateSaleRepository gateSaleUserRepository;
	
	@Autowired
	GateSaleUserListRepository gateSaleUserListRepository;
	
	@Autowired
	GateSaleDiscountRepository gateSaleDiscountRepository;
	
	@Autowired
	GateEmployeeRepository gateEmployeeRepository;
	
	@Autowired
	GetGateEmployeeRepository getGateEmployeeRepository;
	
	@Autowired
	GateSaleBillDetailRepository gateSaleBillDetailRepository;
	
	@Autowired
	GateSaleBillDetailResRepository gateSaleBillDetailsRepository;
	
	@Autowired
	GateSaleBillHeaderResRepository gateSaleBillHeaderResRepository;
	
	@Autowired
	GateSaleBillHeaderRepository gateSaleBillHeaderRepository;
	
	@Override
	public ErrorMessage saveGateSaleUser(GateSaleUser gateSaleUser) {

		ErrorMessage errorMessage=new ErrorMessage();

		try {
			GateSaleUser gateSaleUserRes=gateSaleUserRepository.save(gateSaleUser);
		
		if(gateSaleUserRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Gate Sale User.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate Sale User Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Gate Sale User.");
			return errorMessage;
		}
		return errorMessage;
		
		
	}

	@Override
	public ErrorMessage deleteGateSaleUser(int userId) {

    ErrorMessage errorMessage=new ErrorMessage();
		
		int isUpdated=gateSaleUserRepository.deleteGateSaleUser(userId);
	
		if(isUpdated==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("GateSaleUser Deleted Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleUser Deletion Failed");
			
		}
		return errorMessage;
	}

	@Override
	public GateSaleUserList getGateSaleUserList() {

		List<GetGateSaleUser> gateSaleUserListRes=gateSaleUserListRepository.findGateSaleUserByDelStatus(); 
		ErrorMessage errorMessage=new ErrorMessage();
		GateSaleUserList gateSaleUserList=new GateSaleUserList();

		if(gateSaleUserListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleUser List Not Found.");
			gateSaleUserList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleUser List Found Successfully.");
			
			gateSaleUserList.setErrorMessage(errorMessage);
			gateSaleUserList.setGateSaleUserList(gateSaleUserListRes);
			
		}
		return gateSaleUserList;
	}

	@Override
	public GateSaleUser getGateSaleUserByUserId(int userId) {

		GateSaleUser gateSaleUserRes=gateSaleUserRepository.findGateSaleUserByUserId(userId); 
		
		if(gateSaleUserRes==null)
		{
			gateSaleUserRes=new GateSaleUser();
			gateSaleUserRes.setError(true);
			gateSaleUserRes.setMessage("GateSaleUser Not Found");
			
		}
		else
		{
			gateSaleUserRes.setError(false);
			gateSaleUserRes.setMessage("GateSaleUser Found Successfully");
		}
		
		return gateSaleUserRes;
	}

	@Override
	public ErrorMessage saveGateSaleDiscount(GateSaleDiscount gateSaleDiscount) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
			GateSaleDiscount gateSaleDiscountRes=gateSaleDiscountRepository.save(gateSaleDiscount);
		
		if(gateSaleDiscountRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Gate Sale Discount.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate Sale Discount Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Gate Sale Discount.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteGateSaleDiscount(int discountId) {

	        ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleDiscountRepository.deleteGateSaleDiscount(discountId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleDiscount Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GateSaleDiscount Deletion Failed");
				
			}
			return errorMessage;
	}

	@Override
	public GateSaleDiscList getGateSaleDiscList() {
		
		List<GateSaleDiscount> gateSaleDiscListRes=gateSaleDiscountRepository.findGateSaleDiscountByDelStatus(0); 
		ErrorMessage errorMessage=new ErrorMessage();
		GateSaleDiscList gateSaleDiscList=new GateSaleDiscList();

		if(gateSaleDiscListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleDiscount List Not Found.");
			gateSaleDiscList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleDiscount List Found Successfully.");
			
			gateSaleDiscList.setErrorMessage(errorMessage);
			gateSaleDiscList.setGateSaleDiscountList(gateSaleDiscListRes);
			
		}
		return gateSaleDiscList;
	}

	@Override
	public GateSaleDiscount getGateSaleDiscByDiscId(int discountId) {

		GateSaleDiscount gateSaleDiscRes=gateSaleDiscountRepository.findGateSaleDiscountByDiscountId(discountId); 
		
		if(gateSaleDiscRes==null)
		{
			gateSaleDiscRes=new GateSaleDiscount();
			gateSaleDiscRes.setError(true);
			gateSaleDiscRes.setMessage("GateSaleDiscount Not Found");
			
		}
		else
		{
			gateSaleDiscRes.setError(false);
			gateSaleDiscRes.setMessage("GateSaleDiscount Found Successfully");
		}
		
		return gateSaleDiscRes;
	}

	@Override
	public ErrorMessage saveGateEmployee(GateEmployee gateEmployee) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
			GateEmployee gateEmployeeRes=gateEmployeeRepository.save(gateEmployee);
		
		if(gateEmployeeRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Employee.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Employee Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Employee.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteGateEmployee(int empId) {
		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateEmployeeRepository.deleteGateEmployee(empId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GateEmployee Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GateEmployee Deletion Failed");
				
			}
			return errorMessage;
	}

	@Override
	public GetGateSaleEmpList getGateEmpList() {
	
		List<GetGateSaleEmp> gateEmpListRes=getGateEmployeeRepository.getGateEmpList(); 
		ErrorMessage errorMessage=new ErrorMessage();
		GetGateSaleEmpList getGateSaleEmpList=new GetGateSaleEmpList();

		if(gateEmpListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Gate Employee List Not Found.");
			getGateSaleEmpList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate Employee List Found Successfully.");
			
			getGateSaleEmpList.setErrorMessage(errorMessage);
			getGateSaleEmpList.setGetGateSaleEmpList(gateEmpListRes);
			
		}
		return getGateSaleEmpList;
	}

	@Override
	public GetGateSaleEmp getGateEmpByEmpId(int empId) {
		GetGateSaleEmp getGateSaleEmpRes=getGateEmployeeRepository.getGateEmpByEmpId(empId); 
		
		if(getGateSaleEmpRes==null)
		{
			getGateSaleEmpRes=new GetGateSaleEmp();
			getGateSaleEmpRes.setError(true);
			getGateSaleEmpRes.setMessage("Gate Employee Not Found");
			
		}
		else
		{
			getGateSaleEmpRes.setError(false);
			getGateSaleEmpRes.setMessage("Gate Employee Found Successfully");
		}
		
		return getGateSaleEmpRes; 
	}

	@Override
	public GateSaleDiscList getGateSaleDiscListByCatId(int catId) {
	
		List<GateSaleDiscount> gateSaleDiscListRes=gateSaleDiscountRepository.findGateSaleDiscountByCatIdAndDelStatus(catId,0); 
		ErrorMessage errorMessage=new ErrorMessage();
		GateSaleDiscList gateSaleDiscList=new GateSaleDiscList();

		if(gateSaleDiscListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleDiscount List Not Found.");
			gateSaleDiscList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleDiscount List Found Successfully.");
			
			gateSaleDiscList.setErrorMessage(errorMessage);
			gateSaleDiscList.setGateSaleDiscountList(gateSaleDiscListRes);
			
		}
		return gateSaleDiscList;
	}

	@Override
	public GateSaleUser loginUser(String mobile, String password) {

		GateSaleUser gateSaleUserRes=gateSaleUserRepository.findGateSaleUserByMobileNumberAndPassword(mobile,password); 
		
		if(gateSaleUserRes==null)
		{
			gateSaleUserRes=new GateSaleUser();
			gateSaleUserRes.setError(true);
			gateSaleUserRes.setMessage("Invalid Credentials");
			
		}
		else
		{
			gateSaleUserRes.setError(false);
			gateSaleUserRes.setMessage("Login Successful");
		}
		
		return gateSaleUserRes;
	}

	@Override
	public ErrorMessage saveGateSaleBill(GateSaleBillHeader gateSaleBillHeader) {
         
		GateSaleBillHeader gateSaleBillHeaderRes=gateSaleBillHeaderRepository.saveAndFlush(gateSaleBillHeader);
		ErrorMessage errorMessage=new ErrorMessage();
		try {
		if(gateSaleBillHeaderRes!=null)
		{
		int billId=gateSaleBillHeaderRes.getBillId();
		for(GateSaleBillDetail gateSaleBillDetail:gateSaleBillHeader.getGateSaleBillDetailList())
		{
			gateSaleBillDetail.setBillId(billId);
			GateSaleBillDetail gateSaleBillDetailRes=gateSaleBillDetailRepository.saveAndFlush(gateSaleBillDetail);
			
		}
		errorMessage.setError(false);
		errorMessage.setMessage("GateSaleBill Inserted Successfully.");
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleBill Insertion Failed.");
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleBill Insertion Failed.Exc");
		}
		return errorMessage;
	}

	@Override
	public List<GateSaleBillHeaderRes> gateBillHeaderAndDetails(String fromDate, String toDate, int isApproved,
			int approvedUserId, int amtIsCollected, int collectorUserId) {
		List<GateSaleBillHeaderRes> gateSaleBillHeaderRes=new ArrayList<GateSaleBillHeaderRes>();
		
		if(isApproved==2&&approvedUserId!=0&amtIsCollected==2&collectorUserId==0)
			{
				gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findAmtIsCollectedAndByBillDateBetween(2,fromDate,toDate);
				for(int i=0;i<gateSaleBillHeaderRes.size();i++)
				{
				List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
				gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
				}
			}
		 else
		 if(isApproved==1&&approvedUserId==0&amtIsCollected==0&collectorUserId==0)
		{
			gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findGateSaleBillHeaderResByIsApproved(isApproved);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}
		else if(isApproved==2&&approvedUserId!=0&amtIsCollected==0&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndApprovedUserIdAndBillDateBetween(2,approvedUserId,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}else if(isApproved>1&&approvedUserId==0&amtIsCollected==0&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndBillDateBetween(isApproved,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}
		else if(isApproved==3&&approvedUserId!=0&amtIsCollected==0&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndApprovedUserIdAndBillDateBetween(3,approvedUserId,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}else if(isApproved==2&&approvedUserId!=0&amtIsCollected==1&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndAmtIsCollected(isApproved,amtIsCollected);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}else if(isApproved==2&&approvedUserId!=0&amtIsCollected==2&collectorUserId!=0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndAmtIsCollectedAndCollectedUserIdAndBillDateBetween(isApproved,amtIsCollected,collectorUserId,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}
		
		return gateSaleBillHeaderRes;
	}

	@Override
	public ErrorMessage approveGetSaleBill(int billId, int isApproved, String approvedDate, int approvedUserId) {

		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleBillHeaderRepository.approveGetSaleBill(billId,isApproved,approvedDate,approvedUserId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GetSaleBill updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GetSaleBill updation Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public ErrorMessage collectGetSaleAmt(int billId, int amtIsCollected, String collectedDate, int collectedUserId) {

		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleBillHeaderRepository.updateCollectGetSaleAmt(billId,amtIsCollected,collectedDate,collectedUserId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GetSaleBill updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GetSaleBill updation Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public ErrorMessage updateUserToken(int userId, String token) {

		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleUserRepository.updateUserToken(userId,token);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("User Token Updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("User Token updation Failed");
				
			}
			return errorMessage;
		
	}

}
