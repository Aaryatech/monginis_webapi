package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

	@Query(value="select f.*,r.route_name from m_franchisee f,m_fr_route r where f.fr_route_id=r.route_id And f.fr_code=:frCode And f.del_status=:delStatus",nativeQuery=true)
	public Franchise findByFrCodeAndDelStatus(@Param("frCode")String frCode,@Param("delStatus") int delStatus);
	
	//For New Login with delStatus 0 and 2 ie active and non regular
	@Query(value="select f.*,r.route_name from m_franchisee f,m_fr_route r where f.fr_route_id=r.route_id And f.fr_code=:frCode And f.del_status IN (0,2)",nativeQuery=true)
	public Franchise findByFrCodeAndDelStatusZeroTwo(@Param("frCode")String frCode);

	@Query(value="select is_same_state from m_franchisee where fr_id=(select fr_id from t_bill_header where bill_no=:billNo)",nativeQuery=true)
	public int getIsSameState(@Param("billNo")int billNo);

}
