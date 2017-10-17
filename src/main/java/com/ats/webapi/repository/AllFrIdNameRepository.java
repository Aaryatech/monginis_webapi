package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.AllFrIdName;

public interface AllFrIdNameRepository extends JpaRepository<AllFrIdName, Integer> {
	
	@Query(value=" SELECT fr_id,fr_name from m_franchisee WHERE del_status=0 ",nativeQuery=true)
	
	List<AllFrIdName> getAllFrIdName();
	
@Query(value="select m_franchisee.fr_id,m_franchisee.fr_name from m_franchisee where m_franchisee.fr_id NOT IN(select t_order.fr_id from t_order where order_date=:orderDate) "
			
			
			,nativeQuery=true)
	
	public List<AllFrIdName> findNonOrder(@Param("orderDate") String orderDate);

}

