package com.ats.webapi.service;

import com.ats.webapi.model.LoginResponse;
import com.ats.webapi.model.User;

public interface UserService {

	public LoginResponse findUserByUsername(String username,String password);

	public String save(User user);
}
