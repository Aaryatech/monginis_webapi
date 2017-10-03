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
		
		
	
		
		SpringApplication.run(MonginisWebApiApplication.class, args);
	}
	
}
