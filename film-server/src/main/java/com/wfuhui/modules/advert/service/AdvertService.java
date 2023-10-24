package com.wfuhui.modules.advert.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.advert.entity.AdvertEntity;


/**
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public interface AdvertService {
	
	AdvertEntity queryObject(Integer id);
	
	List<AdvertEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AdvertEntity advert);
	
	void update(AdvertEntity advert);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
