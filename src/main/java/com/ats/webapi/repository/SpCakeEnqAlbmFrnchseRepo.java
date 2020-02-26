package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.album.SpCakeEnqAlbmFrnchse;

public interface SpCakeEnqAlbmFrnchseRepo extends JpaRepository<SpCakeEnqAlbmFrnchse, Integer> {

	@Query(value="SELECT \n" + 
			"		sp.*,\n" + 
			"        enq.cust_name,\n" + 
			"        enq.enquiry_no,\n" + 
			"        enq.cust_name,\n" + 
			"        enq.mobile_no,\n" + 
			"        enq.photo,\n" + 
			"        enq.enquiry_date,\n" + 
			"        enq.enquiry_date_time,\n" + 
			"        enq.approved_date_time,\n" + 
			"        enq.approved_user_id,\n" + 
			"        enq.approved_user_name,\n" + 
			"        enq.status,\n" + 
			"        enq.no_notifictn_fired,\n" + 
			"        enq.ex_var1,\n" + 
			"        enq.ex_var2,\n" + 
			"        enq.ex_int1,\n" + 
			"        enq.ex_int2,\n" + 
			"        fr.fr_name,\n" + 
			"        fr.fr_id\n" + 
			"FROM 	\n" + 
			"		t_sp_cake_album sp,\n" + 
			"        t_album_enquiry enq, \n" + 
			"        m_franchisee fr\n" + 
			"WHERE\n" + 
			"		fr.fr_id=enq.fr_id AND\n" + 
			"		enq.album_id=sp.album_id\n" + 
			"        AND sp.del_status=0",nativeQuery=true)
	public List<SpCakeEnqAlbmFrnchse> getSpcakeEnqAlbmFrData();
	
	
	/*@Query(value="SELECT sp.*, enq.cust_name, enq.enquiry_no, enq.cust_name, enq.mobile_no, enq.photo, enq.enquiry_date, enq.enquiry_date_time, enq.approved_date_time, enq.approved_user_id, enq.approved_user_name, enq.status, enq.no_notifictn_fired, enq.ex_var1, enq.ex_var2, enq.ex_int1, enq.ex_int2, fr.fr_name, fr.fr_id FROM t_sp_cake_album sp, t_album_enquiry enq, m_franchisee fr WHERE fr.fr_id=enq.fr_id AND enq.album_id=sp.album_id AND sp.del_status=0 AND enq.enquiry_date BETWEEN :fromDate AND :toDate",nativeQuery=true)
	public List<SpCakeEnqAlbmFrnchse> getSpcakeEnqAlbmFrDataByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	*/
	 
	@Query(value="SELECT c.album_id,c.album_code,c.album_name, " + 
			"	c.sp_id,c.photo1,c.photo2,c.min_wt,c.max_wt,c.flavour_id, " + 
			"	c.album_desc,c.is_active,c.del_status,c.is_visible_to_album,c.mrp_rate1, " + 
			"	c.cust_name, c.enquiry_no,  c.mobile_no, c.photo, c.enquiry_date, c.enquiry_date_time, c.approved_date_time, c.approved_user_id, c.approved_user_name, c.status, c.no_notifictn_fired, c.ex_var1, c.ex_var2, c.ex_int1, c.ex_int2, c.fr_name, c.fr_id   " + 
			"	FROM " + 
			"	(SELECT 1 flag, sp.*, enq.cust_name, enq.enquiry_no,  enq.mobile_no, enq.photo, enq.enquiry_date, enq.enquiry_date_time, enq.approved_date_time, enq.approved_user_id, enq.approved_user_name, enq.status, enq.no_notifictn_fired, enq.ex_var1, enq.ex_var2, enq.ex_int1, enq.ex_int2, fr.fr_name, fr.fr_id,  " + 
			" m_sp_cake_category.mrp_rate1 " + 
			"	FROM t_sp_cake_album sp, t_album_enquiry enq, m_franchisee fr, m_sp_cake_category   " + 
			" " + 
			"	WHERE m_sp_cake_category.sp_id=sp.sp_id and fr.fr_id=enq.fr_id AND enq.album_id=sp.album_id AND sp.del_status=0 AND enq.enquiry_date BETWEEN :fromDate and :toDate and \n" + 
			"	enq.enquiry_no  IN (select enq_no from t_album_enq_chat where del_status=1)	 " + 
			"	UNION ALL " + 
			"	SELECT 2 flag, sp.*, enq.cust_name, enq.enquiry_no, enq.mobile_no, enq.photo, enq.enquiry_date, enq.enquiry_date_time, enq.approved_date_time, enq.approved_user_id, enq.approved_user_name, enq.status, enq.no_notifictn_fired, enq.ex_var1, enq.ex_var2, enq.ex_int1, enq.ex_int2, fr.fr_name, fr.fr_id " + 
			", m_sp_cake_category.mrp_rate1	FROM t_sp_cake_album sp, t_album_enquiry enq, m_franchisee fr,m_sp_cake_category  " + 
			"	WHERE m_sp_cake_category.sp_id=sp.sp_id and fr.fr_id=enq.fr_id AND enq.album_id=sp.album_id AND sp.del_status=0 AND enq.enquiry_date BETWEEN :fromDate and :toDate and  " + 
			"	enq.enquiry_no NOT IN (select enq_no from t_album_enq_chat where del_status=1) " + 
			" " + 
			"	) c ORDER BY c.flag ASC, c.enquiry_no DESC LIMIT 100",nativeQuery=true)
	public List<SpCakeEnqAlbmFrnchse> getSpcakeEnqAlbmFrDataByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
}
