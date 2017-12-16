package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetStationAllocation;

@Repository
public interface GetStationAllocRepository extends JpaRepository<GetStationAllocation, Integer>{

	@Query(value="Select c.allocation_id,\n" + 
			"c.station_id,\n" + 
			"st.st_name,\n" + 
			"c.shift_id,\n" + 
			"s.shift_name,\n" + 
			"c.emp_mistry_id,\n" + 
			"e.emp_name as emp_mistry_name,\n" + 
			"c.emp_helper_id,e.emp_name as emp_helper_name,\n" + 
			"c.del_status \n" + 
			"from          m_emp e,          m_shift s,                t_prod_station_allocation c ,       m_sp_station st \n" + 
			"WHERE c.del_status=0 \n" + 
			"AND c.shift_id=s.shift_id \n" + 
			"AND c.emp_mistry_id=e.emp_id \n" + 
			"OR c.emp_helper_id=e.emp_id \n" + 
			"AND c.station_id=st.st_id\n" + 
			"group by c.allocation_id",nativeQuery=true)
  List<GetStationAllocation> findStationAllocations();

}
