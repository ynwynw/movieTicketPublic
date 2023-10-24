package com.wfuhui.modules.movie.service;

import com.wfuhui.modules.movie.entity.HistoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 浏览记录
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public interface HistoryService {
	
	HistoryEntity queryObject(Integer id);
	
	List<HistoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HistoryEntity history);
	
	void update(HistoryEntity history);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
