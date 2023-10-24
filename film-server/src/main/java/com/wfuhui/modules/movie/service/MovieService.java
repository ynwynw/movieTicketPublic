package com.wfuhui.modules.movie.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.movie.entity.MovieEntity;

/**
 * 电影
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public interface MovieService {
	
	MovieEntity queryObject(Integer id);
	
	List<MovieEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MovieEntity movie);
	
	void update(MovieEntity movie);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	void updateStatus(Integer status, Integer[] ids);

	List<MovieEntity> getLike(Long userId);
}
