package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.appemp.AppEmp;
import com.ats.webapi.repo.appemp.AppEmpRepo;

@RestController
public class AppEmpController {

	@Autowired
	AppEmpRepo appEmpRepo;

	@RequestMapping(value = { "/saveAppEmp" }, method = RequestMethod.POST)
	public @ResponseBody AppEmp saveAppEmp(@RequestBody AppEmp appEmp) {

		AppEmp res = new AppEmp();

		try { 
			
			if(appEmp!=null) {
				
				AppEmp previousRec=	appEmpRepo.findByEmpId(appEmp.getEmpId());
				System.err.println("APP EMP PREVIOUS ------------------------------ "+previousRec);
				if(previousRec!=null) {
					
					//previousRec.setEmpDsc(appEmp.getEmpDsc());
					//res = appEmpRepo.save(previousRec);
					int ans=appEmpRepo.updateAppEmpDsc(appEmp.getEmpId(),appEmp.getEmpDsc());
					
				}else {
					res = appEmpRepo.save(appEmp);
				}
				
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/updateAppEmpToken" }, method = RequestMethod.POST)
	public @ResponseBody Info updateAdminPwd(@RequestParam("empId") int empId, @RequestParam("token") String token,
			@RequestParam("type") int type) {

		Info info = new Info();
		int res = 0;
		
		if (type == 1) {
			res = appEmpRepo.updateToken1(empId, token);
		} else if (type == 2) {
			res = appEmpRepo.updateToken2(empId, token);
		}else if (type == 3) {
			res = appEmpRepo.updateToken3(empId, token);
		}else if (type == 4) {
			res = appEmpRepo.updateToken4(empId, token);
		}else if (type == 5) {
			res = appEmpRepo.updateToken5(empId, token);
		}else if (type == 6) {
			res = appEmpRepo.updateToken6(empId, token);
		}else if (type == 7) {
			res = appEmpRepo.updateToken7(empId, token);
		}else if (type == 8) {
			res = appEmpRepo.updateToken8(empId, token);
		}
		
		if(res>0) {
			info.setError(false);
			info.setMessage("success");
		}else {
			info.setError(true);
			info.setMessage("failed");
		}

		return info;

	}

}
