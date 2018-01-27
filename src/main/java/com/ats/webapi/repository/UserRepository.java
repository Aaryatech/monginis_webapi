package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 
	User findByUsername(String username);
	User save(User user);
	User findByUsernameAndDelStatus(String username, int i);
	List<User> findByDelStatus(int delStatus);
	
	
	@Transactional
	 @Modifying
	 @Query("UPDATE User SET role_id=:roleId WHERE usr_id=:id")
	 int updateRoleIdByEmpId(@Param("id")int id, @Param("roleId")int roleId);
	
	@Transactional
	 @Modifying
	 @Query("UPDATE User SET token=:token WHERE usr_id=:id")
	int updateUserToken(@Param("id")int userId,@Param("token") String token);
	
	
	@Query(value="select token from m_user where del_status=0",nativeQuery=true)
	List<String> findTokens();
	
	@Query(value="select token from m_user where usr_id not in (:usrId) AND del_status=0",nativeQuery=true)
	List<String> findTokensNotIn(@Param("usrId")int frId);
	
}