package com.wfuhui.modules.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.movie.dao.CollectDao;
import com.wfuhui.modules.movie.entity.CollectEntity;
import com.wfuhui.modules.movie.service.CollectService;



@Service("collectService")
public class CollectServiceImpl implements CollectService {
	@Autowired
	private CollectDao collectDao;
	
	@Override
	public CollectEntity queryObject(Integer id){
		return collectDao.queryObject(id);
	}
	
	@Override
	public List<CollectEntity> queryList(Map<String, Object> map){
		return collectDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return collectDao.queryTotal(map);
	}
	
	@Override
	public void save(CollectEntity collect){
		collectDao.save(collect);
	}
	
	@Override
	public void update(CollectEntity collect){
		collectDao.update(collect);
	}
	
	@Override
	public void delete(Integer id){
		collectDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		collectDao.deleteBatch(ids);
	}

	@Override
	public void remove(Integer movieId, Long userId) {
		collectDao.remove(movieId, userId);
	}
	
}
