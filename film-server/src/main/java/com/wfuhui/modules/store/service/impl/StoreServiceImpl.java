package com.wfuhui.modules.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.store.dao.StoreDao;
import com.wfuhui.modules.store.entity.StoreEntity;
import com.wfuhui.modules.store.service.StoreService;



@Service("storeService")
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreDao storeDao;
	
	@Override
	public StoreEntity queryObject(Integer id){
		return storeDao.queryObject(id);
	}
	
	@Override
	public List<StoreEntity> queryList(Map<String, Object> map){
		return storeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return storeDao.queryTotal(map);
	}
	
	@Override
	public void save(StoreEntity store){
		storeDao.save(store);
	}
	
	@Override
	public void update(StoreEntity store){
		storeDao.update(store);
	}
	
	@Override
	public void delete(Integer id){
		storeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		storeDao.deleteBatch(ids);
	}
	
}
