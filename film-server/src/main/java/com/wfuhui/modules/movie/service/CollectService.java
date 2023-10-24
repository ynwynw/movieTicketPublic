package com.wfuhui.modules.movie.service;

import com.wfuhui.modules.movie.entity.CollectEntity;

import java.util.List;
import java.util.Map;

/**
 * 收藏
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public interface CollectService {
	
	CollectEntity queryObject(Integer id);
	
	List<CollectEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CollectEntity collect);
	
	void update(CollectEntity collect);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void remove(Integer movieId, Long userId);
}
