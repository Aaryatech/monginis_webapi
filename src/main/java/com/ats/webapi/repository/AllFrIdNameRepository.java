package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.AllFrIdName;

public interface AllFrIdNameRepository extends JpaRepository<AllFrIdName, Integer> {
	
	@Query(value=" SELECT fr_id,fr_name from m_franchisee WHERE del_status=0 order by fr_name Asc",nativeQuery=true)	
	List<AllFrIdName> getAllFrIdName();
	
		@Query(value="select m_franchisee.fr_id,m_franchisee.fr_name from m_franchisee where m_franchisee.del_status=0 And  m_franchisee.fr_id NOT"
					+" IN(select t_order.fr_id from t_order where order_date=:orderDate AND menu_id=:menuId) order by m_franchisee.fr_name Asc"
					,nativeQuery=true)
	public List<AllFrIdName> findNonOrders(@Param("orderDate") String orderDate, @Param("menuId") int menuId);

		@Query(value=" SELECT fr_id,fr_name from m_franchisee where fr_id=:frId",nativeQuery=true)
		AllFrIdName findByFrId(@Param("frId")int frId);

		
		
		@Query(value="SELECT fr_id,fr_name from m_franchisee where del_status=:del", nativeQuery=true)
		List<AllFrIdName> getAllFrIdNameByDelStatus(@Param("del")int del);
		
		@Query(value="select\n" + 
				"        m_franchisee.fr_id,\n" + 
				"        m_franchisee.fr_name \n" + 
				"    from\n" + 
				"        m_franchisee \n" + 
				"    where\n" + 
				"        m_franchisee.del_status=0 \n" + 
				"        And  m_franchisee.fr_id NOT IN(\n" + 
				"            select\n" + 
				"                t_order.fr_id \n" + 
				"            from\n" + 
				"                t_order \n" + 
				"            where\n" + 
				"                production_date=:productionDate \n" + 
				"                AND menu_id=:menuId\n" + 
				"        ) \n" + 
				"    order by\n" + 
				"        m_franchisee.fr_name Asc",nativeQuery=true)
		public List<AllFrIdName> findNonProduction(@Param("productionDate") String productionDate, @Param("menuId") int menuId);

		@Query(value=" SELECT fr_id,fr_name from m_franchisee order by fr_name Asc",nativeQuery=true)	
		List<AllFrIdName> getAllFranchiseIdAndName();
}

