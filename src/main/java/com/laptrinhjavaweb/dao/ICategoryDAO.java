package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);

}
