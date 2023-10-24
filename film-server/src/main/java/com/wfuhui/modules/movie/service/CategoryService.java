package com.wfuhui.modules.movie.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.movie.entity.CategoryEntity;

/**
 * 分类
 * 
 * @author lzl
 * @email 931708230@qq.com
 * @date 2017-07-14 13:43:12
 */
public interface CategoryService {
	
	CategoryEntity queryObject(Integer id);
	
	List<CategoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CategoryEntity category);
	
	void update(CategoryEntity category);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
