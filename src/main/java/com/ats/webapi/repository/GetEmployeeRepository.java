package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetEmployee;

@Repository
public interface GetEmployeeRepository extends JpaRepository<GetEmployee, Integer>{

	@Query(value="Select e.emp_id ,e.emp_name,e.dept_id,d.dept_name,e.is_used,e.del_status from m_emp e,m_cm_dept d where e.dept_id=d.dept_id And e.del_status=0  ",nativeQuery=true)
	List<GetEmployee> findGetEmployeeByDelStatus();

}
