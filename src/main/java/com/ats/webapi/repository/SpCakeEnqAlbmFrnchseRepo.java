package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
			"        AND sp.del_status=1",nativeQuery=true)
	public List<SpCakeEnqAlbmFrnchse> getSpcakeEnqAlbmFrData();
}
