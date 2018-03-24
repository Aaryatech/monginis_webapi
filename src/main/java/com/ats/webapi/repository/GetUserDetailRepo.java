package com.ats.webapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ats.webapi.model.GetUserDetail;

public interface GetUserDetailRepo extends JpaRepository<GetUserDetail, Integer> {
	
	@Query(value="SELECT u.*,d.dept_name,r.role_name FROM m_user u,m_cm_dept d,m_assign_role r " + 
			"WHERE u.role_id=r.role_id AND u.dept_id=d.dept_id AND u.del_status=0 ",nativeQuery=true)
	List<GetUserDetail> getUserDetail();

}
