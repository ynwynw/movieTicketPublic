package com.wfuhui.modules.movie.service;


import java.util.List;
import java.util.Map;

import com.wfuhui.modules.movie.entity.SeatEntity;

/**
 * 座位
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public interface SeatService {
	
	SeatEntity queryObject(Integer id);
	
	List<SeatEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SeatEntity seat);
	
	void update(SeatEntity seat);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
