package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.AlbumEnquiry;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.album.Album;
import com.ats.webapi.repository.AlbumEnquiryRepo;


@RestController
public class EnquiryController {

	@Autowired AlbumEnquiryRepo albmEnq;
	
	// --Get all AlbumEnquiry--
		@GetMapping("/getAllEnquiry")
		public List<AlbumEnquiry> getAllPurposesWithName() {
			return albmEnq.findByDelStatus(0);
		}
		
		// --Save new AlbumEnquiry--
		@PostMapping("/saveAlbumEnquiry")
		public AlbumEnquiry saveAlbumEnquiry(@RequestBody AlbumEnquiry enq) {
			return albmEnq.save(enq);
		}
		
		// --Get AlbumEnquiry By Id--
		@PostMapping("/getEnquiryById")
		public AlbumEnquiry getEnquiryById(@RequestParam int enqNo) {
			return albmEnq.findByEnquiryNoAndDelStatus(enqNo, 0);
		}
		
		// --deleteAlbumEnquiry--
		@PostMapping("/deleteAlbumEnquiry")
		public Info deleteAlbumEnquiry(@RequestParam int enqNo) {
			Info info = null;

			AlbumEnquiry albm = albmEnq.findByEnquiryNo(enqNo);

			if (albm != null) {
				albm.setDelStatus(1);
				AlbumEnquiry updatedAlbmEnq = albmEnq.save(albm);
				info = new Info();
				info.setError(false);
				info.setMessage("AlbumEnquiry Deleted Successfully");
			} else {
				info = new Info();
				info.setError(true);
				info.setMessage("AlbumEnquiry Deletion Failed");
			}
			return info;
		}
		
		// --Update AlbumId--
				@PostMapping("/updateAlbumId")
				public Info saveAlbumEnquiry(@RequestParam int enqId, @RequestParam(value = "albmId") int albmId) {
				Info info = new Info();
					int updatedAlbmId = albmEnq.updtAlbmIdByEnqId(enqId, albmId);
					
					if(updatedAlbmId!=0) {
						info.setError(false);
						info.setMessage("AlbumEnquiry Updated Successfully");
					} else {
						info = new Info();
						info.setError(true);
						info.setMessage("AlbumEnquiry Update Failed");
					}						
					
					return info;
				}
				
				@RequestMapping(value = { "/getFrnchseEnqAlbmInfo" }, method = RequestMethod.GET)
				public @ResponseBody List<AlbumEnquiry> getFrnchseEnqAlbmInfo() {

					List<AlbumEnquiry> albumList = new ArrayList<>();

					try {

						albumList = albmEnq.getAlbmFrDetail();

					} catch (Exception e) {

						e.printStackTrace();

					}
					return albumList;

				}
}
