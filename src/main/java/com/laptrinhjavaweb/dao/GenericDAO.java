package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update(String sql, Object... parameters);
    Long insert(String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
