package com.wfuhui.modules.advert.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.advert.dao.AdvertDao;
import com.wfuhui.modules.advert.entity.AdvertEntity;
import com.wfuhui.modules.advert.service.AdvertService;

import java.util.List;
import java.util.Map;


@Service("advertService")
public class AdvertServiceImpl implements AdvertService {
	@Autowired
	private AdvertDao advertDao;
	
	@Override
	public AdvertEntity queryObject(Integer id){
		return advertDao.queryObject(id);
	}
	
	@Override
	public List<AdvertEntity> queryList(Map<String, Object> map){
		return advertDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return advertDao.queryTotal(map);
	}
	
	@Override
	public void save(AdvertEntity advert){
		advertDao.save(advert);
	}
	
	@Override
	public void update(AdvertEntity advert){
		advertDao.update(advert);
	}
	
	@Override
	public void delete(Integer id){
		advertDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		advertDao.deleteBatch(ids);
	}
	
}
