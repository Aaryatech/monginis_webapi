package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 
	User findByUsername(String username);
	User save(User user);
	User findByUsernameAndDelStatus(String username, int i);
	
}