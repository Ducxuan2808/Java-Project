package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pagable;

public interface IUserService {

	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	
}
