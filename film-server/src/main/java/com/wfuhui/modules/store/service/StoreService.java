package com.wfuhui.modules.store.service;

import com.wfuhui.modules.store.entity.StoreEntity;

import java.util.List;
import java.util.Map;

/**
 * 影院
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 * @date 07 08:21:58
 */
public interface StoreService {
	
	StoreEntity queryObject(Integer id);
	
	List<StoreEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StoreEntity store);
	
	void update(StoreEntity store);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
