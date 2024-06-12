package com.laptrinhjavaweb.dao.impl;

import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pagable;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO{

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription ,categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ? )");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getThumbnail(), 
				newModel.getShortDescription(), newModel.getCategoryId(), newModel.getCreatedDate(), 
				newModel.getCreatedBy());
			
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql =new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription= ?, content = ? , categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ?  where id = ?");

	    update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(), 
	    		updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(),
	    		updateNew.getCreatedBy(), updateNew.getModifiedDate(),
	    		updateNew.getModifiedBy(), updateNew.getId());
		System.out.println(sql.toString());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewModel> findAll(Pagable pagable) {
		//String sql = "SELECT * FROM news LIMIT ?,?";
		StringBuilder sql  = new StringBuilder("SELECT * FROM news");
		if(pagable.getSorter() != null && StringUtils.isNotBlank(pagable.getSorter().getSortName())&& StringUtils.isNotBlank(pagable.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pagable.getSorter().getSortName()+" "+pagable.getSorter().getSortBy()+"");
		}
		if(pagable.getOffset() !=null && pagable.getLimit() !=null) {
			sql.append(" LIMIT "+pagable.getOffset()+", "+pagable.getLimit()+"");
		}
		System.out.print(sql.toString());
		return query(sql.toString(), new NewMapper());
		
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

	

}
