package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.AlbumEnquiry;
import com.ats.webapi.model.album.Album;


public interface AlbumEnquiryRepo extends JpaRepository<AlbumEnquiry, Integer> {

	List<AlbumEnquiry> findByDelStatus(int del);

	AlbumEnquiry findByEnquiryNoAndDelStatus(int enqNo, int del);

	AlbumEnquiry findByEnquiryNo(int enqNo);

	@Transactional
	@Modifying
	@Query(value="UPDATE AlbumEnquiry SET album_id=:albmId WHERE enquiry_no=:enqId")
	int updtAlbmIdByEnqId(@Param("enqId") int enqId, @Param("albmId") int albmId);

	@Query(value="SELECT a.enquiry_no,\n" + 
			"	m.fr_id,\n" + 
			"    m.fr_name AS ex_var3,\n" + 
			"    a.cust_name,\n" + 
			"    a.mobile_no,\n" + 
			"    a.photo,\n" + 
			"    a.enquiry_date,\n" + 
			"    a.enquiry_date_time,\n" + 
			"    a.approved_date_time,\n" + 
			"    a.approved_user_id,\n" + 
			"    a.approved_user_name,\n" + 
			"    a.album_id,\n" + 
			"    a.status,\n" + 
			"    a.del_status,\n" + 
			"    a.no_notifictn_fired,\n" + 
			"    a.ex_var1,\n" + 
			"    a.ex_var2,\n" + 
			"    a.ex_int1,\n" + 
			"    a.ex_int2,\n" + 
			"    a.ex_int3    \n" + 
			"	\n" + 
			"FROM t_album_enquiry a, m_franchisee m\n" + 
			"WHERE a.fr_id=m.fr_id AND\n" + 
			"	a.del_status=1",nativeQuery=true)
	List<AlbumEnquiry> getAlbmFrDetail();

}
