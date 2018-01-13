package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.GetGateSaleEmp;

@Repository
public interface GetGateEmployeeRepository extends JpaRepository<GetGateSaleEmp, Integer>{

	@Query(value="select e.emp_id,e.emp_name,e.is_used,e.dept_id,d.dept_name,e.del_status,e.emp_type,e.emp_mobile,e.emp_dob,e.emp_doj,e.emp_fam_memb,e.disc_id,dis.discount_head,dis.discount_per,e.monthly_limit,e.yearly_limit from m_emp e,m_cm_dept d,m_gatesale_discount dis where e.dept_id=d.dept_id AND e.disc_id=dis.discount_id AND e.del_status=0",nativeQuery=true)
	List<GetGateSaleEmp> getGateEmpList();
	
	@Query(value="select e.emp_id,e.emp_name,e.is_used,e.dept_id,d.dept_name,e.del_status,e.emp_type,e.emp_mobile,e.emp_dob,e.emp_doj,e.emp_fam_memb,e.disc_id,dis.discount_head,dis.discount_per,e.monthly_limit,e.yearly_limit from m_emp e,m_cm_dept d,m_gatesale_discount dis where e.dept_id=d.dept_id AND e.disc_id=dis.discount_id And e.emp_id=:empId",nativeQuery=true)
	GetGateSaleEmp getGateEmpByEmpId(@Param("empId")int empId);

}
