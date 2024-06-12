package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pagable;

public interface IUserDAO {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
