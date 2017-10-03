package com.ats.webapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ats.webapi.model.PostBillDataCommon;
import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.model.PostBillHeader;

@SpringBootApplication(scanBasePackages={"com.ats.webapi"})
public class MonginisWebApiApplication {

	
	public static void main(String[] args) {
		
		
		PostBillDataCommon postBillDataCommon=new PostBillDataCommon();
		
		//(int billNo, int taxApplicable, int invoiceNo, Date billDate, int frId, String frCode,
		//float total, float totalWithoutTax, float totalTax, int status, int delStatus, String remark)
	
		
		Date d=new Date();
		PostBillHeader postBillHeader=new  PostBillHeader(0,10,10,d,17,"db02",100,20,120,1,0,"remark");
		
		/*(int billDetailNo, int billNo, int menuId, int catId, int itemId, int orderQty, int billQty,
				int rateType, float rate, float mrp, float total, float sgstPer, float sgstRs, float cgstPer, float cgstRs,
				float igstPer, float igstRs, float totalWithoutTax, String remark, int delStaus)
		*/
		
		PostBillDetail postBillDetail=new  PostBillDetail(1,0,26,2,2,2,2,2,2,2,22,22,22,22,2,2,2,2,"remark",0);
		
		List<PostBillHeader>postBillHeadersList=new ArrayList<>();
		List<PostBillDetail> postBillDetailsList=new ArrayList<>();
		
		postBillHeadersList.add(postBillHeader);
		postBillDetailsList.add(postBillDetail);
		
			postBillDataCommon.setPostBillHeadersList(postBillHeadersList);
			postBillDataCommon.setPostBillDetailsList(postBillDetailsList);
			
			System.out.println("Test data : "+postBillDataCommon.toString());
		
		SpringApplication.run(MonginisWebApiApplication.class, args);
	}
	
}
