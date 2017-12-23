package com.ats.webapi.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrLoginResponse;
import com.ats.webapi.model.FrTarget;
import com.ats.webapi.model.FrTargetList;
import com.ats.webapi.model.FrTotalSale;
import com.ats.webapi.model.FranchiseSup;
import com.ats.webapi.model.FranchiseSupList;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.GetFranchiseSup;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.FrTargetRepository;
import com.ats.webapi.repository.FrTotalSaleRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.GetFranchiseSupRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class FranchiseeServiceImpl implements FranchiseeService {

    @Autowired
    private FranchiseeRepository franchiseeRepository;

    @Autowired
    FranchiseSupRepository franchiseSupRepository;
    
    @Autowired
    GetFranchiseSupRepository getFrSupRepository;
    
    @Autowired
    FrTargetRepository frTargetRepository;
    
    @Autowired
    FrTotalSaleRepository frTotalSaleRepository;
    
	@Override
	public String saveFranchisee(Franchisee franchisee) {
		
		Franchisee dbFranchisee= franchiseeRepository.save(franchisee);
		ErrorMessage errorMessage=new ErrorMessage();

		if(!dbFranchisee.equals(null))
		{
		 errorMessage.setError(false);
		 errorMessage.setMessage("Franchisee Inserted Successfully");
		
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Franchisee insertion Failed");
			
		}
		return JsonUtil.javaToJson(errorMessage);

	}

	@Override
	public List<Franchisee> findAllFranchisee() {
		 List<Franchisee> franchisee=new ArrayList<Franchisee>();
			franchisee=franchiseeRepository.findAllByDelStatus(0);
	
		
		return franchisee;
	}

	@Override
	public Franchisee findFranchisee(int frId) {
		Franchisee franchisee=franchiseeRepository.findOne(frId);
	     return franchisee;
	}

	@Override
	public String findFranchiseeByFrCode(String frCode, String frPassword) {
	
		String dbFrCode = null;
		String dbPassword = null;
		String jsonFr = "{}";
        Franchisee dbFranchisee=new Franchisee();

			
			FrLoginResponse frLoginResponse = new FrLoginResponse();
            ErrorMessage errorMessage=new ErrorMessage();
			try {
				dbFranchisee = franchiseeRepository.findByFrCodeAndDelStatus(frCode,0);
				System.out.println(" details "+dbFranchisee.toString());
				
				dbFrCode = dbFranchisee.getFrCode();
				dbPassword = dbFranchisee.getFrPassword();
			} catch (Exception e) {
				
				System.out.println("Exception while finding prev fr "+e.getMessage());
				
				frLoginResponse.setFranchisee(dbFranchisee);
				errorMessage.setError(true);
				errorMessage.setMessage("Franchisee Not Registerd");
				frLoginResponse.setErrorMessage(errorMessage);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			try {
				if (dbFranchisee.getFrCode() == null || dbFranchisee.getFrPassword() == null||dbFranchisee.getFrCode().equalsIgnoreCase("")||dbFranchisee.getFrPassword().equalsIgnoreCase("")) {

				
					System.out.println("Exception fr details null ");
					
					 frLoginResponse.setFranchisee(dbFranchisee);
					 errorMessage.setError(true);
					 errorMessage.setMessage("Franchisee Not Registered");
					 frLoginResponse.setErrorMessage(errorMessage);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);
					
				} else if (dbFrCode.equalsIgnoreCase(frCode) && dbPassword.equals(frPassword)) {
					
				
					frLoginResponse.setFranchisee(dbFranchisee);
					errorMessage.setError(false);
					errorMessage.setMessage("Franchisee displayed Successfully");
					frLoginResponse.setErrorMessage(errorMessage);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);

				} else if (dbFrCode.equalsIgnoreCase(frCode) && dbPassword != frPassword) {
					
					 frLoginResponse.setFranchisee(dbFranchisee);
					 errorMessage.setError(true);
					 errorMessage.setMessage("Invalid login details");
					 frLoginResponse.setErrorMessage(errorMessage);
					 jsonFr = JsonUtil.javaToJson(frLoginResponse);
				}
			} catch (Exception e) {
				System.out.println("Exception while converting prev fr "+e.getMessage());
				
				
				 frLoginResponse.setFranchisee(dbFranchisee);
				 errorMessage.setError(true);
				 errorMessage.setMessage("Franchisee Not Registered");
			     frLoginResponse.setErrorMessage(errorMessage);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			return jsonFr;

		}

	@Override
	public FranchiseSup saveFranchiseSup(FranchiseSup franchiseSup) {

		FranchiseSup franchiseSupRes=franchiseSupRepository.saveAndFlush(franchiseSup);
		return franchiseSupRes;
	}

	@Override
	public Info deleteFranchiseSup(int frId) {

		int delStatus=franchiseSupRepository.deleteFranchiseSup(frId);
		Info info=new Info();
		if(delStatus==1)
		{
			info.setError(false);
			info.setMessage("Franchisee Sup Deleted Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Franchisee Sup Deletion Failed ");
		}
		return info;
	}

	@Override
	public FranchiseSupList getFranchiseSupList() {

		List<GetFranchiseSup> getFrSupList=getFrSupRepository.findByDelStatus();
		FranchiseSupList franchiseSupList=new FranchiseSupList();
		Info info=new Info();
		
		if(!getFrSupList.isEmpty())
		{
			info.setMessage("Franchisee SupList Found Successfully.");
			info.setError(false);
			franchiseSupList.setInfo(info);
			franchiseSupList.setFrList(getFrSupList);
		}
		else
		{
			info.setMessage("Franchisee SupList Not Found.");
			info.setError(true);
			franchiseSupList.setInfo(info);
		}
		return franchiseSupList;
	}

	@Override
	public FranchiseSup getFranchiseSup(int id) {

		FranchiseSup franchiseSup=franchiseSupRepository.findFranchiseSupById(id);
		return franchiseSup;
	}

	@Override
	public Info saveFrTarget(List<FrTarget> frTargetList) {

		Info info=null;
		try
		{
		
		for(int i=0;i<frTargetList.size();i++)
		{
			FrTarget frTarget=frTargetList.get(i);
			FrTarget frTargetRes=frTargetRepository.saveAndFlush(frTarget);
		}
		 info=new Info();
		 info.setError(false);
		 info.setMessage("Fr Target Saved Successfully");
		}
		catch(Exception e)
		{
			info=new Info();
			info.setError(true);
			info.setMessage("Fr Target Failed to Save");
			
			System.out.println("Exception In /saveFrTarget FrService");
		}
		return info;
	}

	@Override
	public FrTargetList getFrTargetList(int frId,int year) {

		List<FrTarget> frtargetListRes=frTargetRepository.findFrTargetByFrIdAndFrTargetYearAndDelStatus(frId,year,0);
		FrTargetList frTargetList=new FrTargetList();
		
		if(!frtargetListRes.isEmpty())
		{
			Info info=new Info();
			info.setError(false);
            info.setMessage("FrTarget Found Successfully.");
            frTargetList.setInfo(info);
			frTargetList.setFrTargetList(frtargetListRes);
		}
		else
		{
			Info info=new Info();
			info.setError(true);
            info.setMessage("FrTarget Not Found.");
            frTargetList.setInfo(info);
		}
		return frTargetList;
	}

	@Override
	public FrTotalSale getFrTargetList(int frId, int month, int year) {
		
		FrTotalSale frTotalSale=new FrTotalSale();
		try {
		Date lastDate = getLastDateOfMonth(year,month);
		System.out.println("lastDate:"+lastDate);

		String firstDate=year+"-"+month+"-"+01;
		
		System.out.println("firstDate:"+firstDate);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		
		
		 frTotalSale=frTotalSaleRepository.findFrTotalSale(frId,firstDate,sm.format(lastDate));
		}
		catch(Exception e)
		{
			System.out.println("Exc In getFrTargetList"+e.getMessage());
		}
		return frTotalSale;
	}
	public static Date getLastDateOfMonth(int year, int month) {
		  Calendar calendar = new GregorianCalendar(year, month,
		  Calendar.DAY_OF_MONTH);
		  calendar.set(Calendar.DAY_OF_MONTH,
		  calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		  return calendar.getTime();
		}
	
}
