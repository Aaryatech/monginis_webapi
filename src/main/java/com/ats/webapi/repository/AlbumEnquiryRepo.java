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
	
	List<AlbumEnquiry> findByDelStatusAndStatus(int del,int status);

	@Transactional
	@Modifying
	@Query(value="UPDATE AlbumEnquiry SET album_id=:albmId WHERE enquiry_no=:enqId")
	int updtAlbmIdByEnqId(@Param("enqId") int enqId, @Param("albmId") int albmId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_album_enquiry SET ex_int1=:status WHERE enquiry_no=:enqId",nativeQuery=true)
	int updateNotifyStatusByEnqId(@Param("enqId") int enqId, @Param("status") int status);

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
			"	a.del_status=0",nativeQuery=true)
	List<AlbumEnquiry> getAlbmFrDetail();
	
	@Query(value="SELECT a.enquiry_no, m.fr_id, m.fr_name AS ex_var3, a.cust_name, a.mobile_no, a.photo, a.enquiry_date, a.enquiry_date_time, a.approved_date_time, a.approved_user_id, a.approved_user_name, a.album_id, a.status, a.del_status, a.no_notifictn_fired, a.ex_var1, a.ex_var2, a.ex_int1, a.ex_int2, a.ex_int3 FROM t_album_enquiry a, m_franchisee m WHERE a.fr_id=m.fr_id AND a.del_status=0 AND a.enquiry_date BETWEEN :fromDate AND :toDate",nativeQuery=true)
	List<AlbumEnquiry> getAlbmFrDetailByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_album_enquiry SET status=:status,approved_date_time=:approvedDateTime WHERE enquiry_no=:enqId",nativeQuery=true)
	int updateEnquiryStatusByEnqId(@Param("enqId") int enqId, @Param("status") int status,@Param("approvedDateTime") String approvedDateTime);
	 
	@Transactional
	@Modifying
	@Query(value="UPDATE AlbumEnquiry SET ex_var1=:token WHERE fr_id=:frId")
	int updtAlbmTokenForFrLogin(@Param("token") String token, @Param("frId") int frId);

}
