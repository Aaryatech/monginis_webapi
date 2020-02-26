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
	
	//New Sachin 18-02-2020
	@Query(value="SELECT t_album_enquiry.* from t_album_enquiry where t_album_enquiry.status=:status and t_album_enquiry.del_status=:del and t_album_enquiry.enquiry_no NOT IN (SELECT t_album_enq_chat.enq_no FROM t_album_enq_chat)\n" + 
			"",nativeQuery=true)
	List<AlbumEnquiry> getAlbumEnqNotNotedByEmp(@Param("del")int del,@Param("status")int status);


	@Transactional
	@Modifying
	@Query(value="UPDATE AlbumEnquiry SET album_id=:albmId WHERE enquiry_no=:enqId")
	int updtAlbmIdByEnqId(@Param("enqId") int enqId, @Param("albmId") int albmId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE t_album_enquiry SET ex_int1=:status WHERE enquiry_no=:enqId",nativeQuery=true)
	int updateNotifyStatusByEnqId(@Param("enqId") int enqId, @Param("status") int status);

	/*@Query(value="SELECT a.enquiry_no,\n" + 
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
			"FROM t_album_enquiry a, m_franchisee m, t_album_enq_chat chat \n" + 
			"WHERE a.fr_id=m.fr_id AND\n" + 
			"	a.del_status=0 and chat.enq_no=a.enquiry_no  order by ",nativeQuery=true)
	List<AlbumEnquiry> getAlbmFrDetail();*/
	
	
	@Query(value="select c.enquiry_no,c.fr_id,c.ex_var3,c.cust_name,  \n" + 
			"   c.mobile_no,  \n" + 
			"   c.photo,  \n" + 
			"   c.enquiry_date,  \n" + 
			"   c.enquiry_date_time,  \n" + 
			"   c.approved_date_time,  \n" + 
			"   c.approved_user_id,  \n" + 
			"   c.approved_user_name,  \n" + 
			"   c.album_id,  \n" + 
			"   c.status,  \n" + 
			"   c.del_status,  \n" + 
			"   c.no_notifictn_fired,  \n" + 
			"   c.ex_var1,  \n" + 
			"   c.ex_var2,  \n" + 
			"   c.ex_int1,  \n" + 
			"   c.ex_int2,\n" + 
			" c.ex_int3\n" + 
			"\n" + 
			"from\n" + 
			"(SELECT a.enquiry_no,1 flag,  \n" + 
			"   m.fr_id,  \n" + 
			"   m.fr_name AS ex_var3,  \n" + 
			"   a.cust_name,  \n" + 
			"   a.mobile_no,  \n" + 
			"   a.photo,  \n" + 
			"   a.enquiry_date,  \n" + 
			"   a.enquiry_date_time,  \n" + 
			"   a.approved_date_time,  \n" + 
			"   a.approved_user_id,  \n" + 
			"   a.approved_user_name,  \n" + 
			"   a.album_id,  \n" + 
			"   a.status,  \n" + 
			"   a.del_status,  \n" + 
			"   a.no_notifictn_fired,  \n" + 
			"   a.ex_var1,  \n" + 
			"   a.ex_var2,  \n" + 
			"   a.ex_int1,  \n" + 
			"   a.ex_int2,\n" + 
			" a.ex_int3\n" + 
			"  \n" + 
			" \n" + 
			"FROM t_album_enquiry a, m_franchisee m\n" + 
			"WHERE a.fr_id=m.fr_id AND  a.enquiry_no  IN (select enq_no from t_album_enq_chat where del_status=1) and\n" + 
			"a.del_status=0  \n" + 
			"\n" + 
			"Union all\n" + 
			"\n" + 
			"SELECT a.enquiry_no,2 flag, \n" + 
			"   m.fr_id,  \n" + 
			"   m.fr_name AS ex_var3,  \n" + 
			"   a.cust_name,  \n" + 
			"   a.mobile_no,  \n" + 
			"   a.photo,  \n" + 
			"   a.enquiry_date,  \n" + 
			"   a.enquiry_date_time,  \n" + 
			"   a.approved_date_time,  \n" + 
			"   a.approved_user_id,  \n" + 
			"   a.approved_user_name,  \n" + 
			"   a.album_id,  \n" + 
			"   a.status,  \n" + 
			"   a.del_status,  \n" + 
			"   a.no_notifictn_fired,  \n" + 
			"   a.ex_var1,  \n" + 
			"   a.ex_var2,  \n" + 
			"   a.ex_int1,  \n" + 
			"   a.ex_int2,\n" + 
			"   a.ex_int3\n" + 
			"      \n" + 
			" \n" + 
			"FROM t_album_enquiry a, m_franchisee m\n" + 
			"WHERE a.fr_id=m.fr_id AND  a.enquiry_no NOT IN (select enq_no from t_album_enq_chat where del_status=1) and\n" + 
			"a.del_status=0   ) c ORDER BY c.flag ASC, c.enquiry_no DESC LIMIT 100",nativeQuery=true)
	List<AlbumEnquiry> getAlbmFrDetail();
	
	
	
	/*
	 * @Query(
	 * value="SELECT a.enquiry_no, m.fr_id, m.fr_name AS ex_var3, a.cust_name, a.mobile_no, a.photo, a.enquiry_date, a.enquiry_date_time, a.approved_date_time, a.approved_user_id, a.approved_user_name, a.album_id, a.status, a.del_status, a.no_notifictn_fired, a.ex_var1, a.ex_var2, a.ex_int1, a.ex_int2, a.ex_int3 FROM t_album_enquiry a, m_franchisee m WHERE a.fr_id=m.fr_id AND a.del_status=0 AND a.enquiry_date BETWEEN :fromDate AND :toDate"
	 * ,nativeQuery=true) List<AlbumEnquiry>
	 * getAlbmFrDetailByDate(@Param("fromDate") String fromDate,@Param("toDate")
	 * String toDate);
	 */
	@Query(value="\n" + 
			"SELECT c.enquiry_no,c.fr_id,c.ex_var3,c.cust_name,    " + 
			"			   c.mobile_no,    " + 
			"			   c.photo,    " + 
			"			   c.enquiry_date,    " + 
			"			   c.enquiry_date_time,   " + 
			"			   c.approved_date_time,   " + 
			"			   c.approved_user_id,    " + 
			"			   c.approved_user_name,    " + 
			"			   c.album_id,   " + 
			"			   c.status,    " + 
			"			   c.del_status,   " + 
			"			   c.no_notifictn_fired,    " + 
			"			   c.ex_var1,   " + 
			"			   c.ex_var2,    " + 
			"			   c.ex_int1,   " + 
			"			   c.ex_int2,  " + 
			"			 c.ex_int3 from " + 
			"( SELECT 1 flag, a.enquiry_no, m.fr_id, m.fr_name AS ex_var3, a.cust_name, a.mobile_no, a.photo, a.enquiry_date, a.enquiry_date_time, a.approved_date_time, a.approved_user_id, a.approved_user_name, a.album_id, a.status, a.del_status, a.no_notifictn_fired, a.ex_var1, a.ex_var2, a.ex_int1, a.ex_int2, a.ex_int3 "
			+ "FROM t_album_enquiry a, m_franchisee m WHERE a.enquiry_no  IN (select enq_no from t_album_enq_chat where del_status=1) and a.fr_id=m.fr_id AND a.del_status=0 AND a.enquiry_date BETWEEN :fromDate AND :toDate " + 
			"UNION ALL " + 
			"SELECT 2 flag, a.enquiry_no, m.fr_id, m.fr_name AS ex_var3, a.cust_name, a.mobile_no, a.photo, a.enquiry_date, a.enquiry_date_time, a.approved_date_time, a.approved_user_id, a.approved_user_name, a.album_id, a.status, a.del_status, a.no_notifictn_fired, a.ex_var1, a.ex_var2, a.ex_int1, a.ex_int2, a.ex_int3 "
			+ "FROM t_album_enquiry a, m_franchisee m WHERE a.enquiry_no NOT IN (select enq_no from t_album_enq_chat where del_status=1) and a.fr_id=m.fr_id AND a.del_status=0 AND a.enquiry_date BETWEEN :fromDate AND :toDate " + 
			" " + 
			") c ORDER BY c.flag ASC, c.enquiry_no DESC LIMIT 100 " + 
			"",nativeQuery=true)
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
