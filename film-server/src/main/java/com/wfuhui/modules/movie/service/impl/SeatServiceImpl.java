package com.wfuhui.modules.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.movie.dao.SeatDao;
import com.wfuhui.modules.movie.entity.SeatEntity;
import com.wfuhui.modules.movie.service.SeatService;



@Service("seatService")
public class SeatServiceImpl implements SeatService {
	@Autowired
	private SeatDao seatDao;
	
	@Override
	public SeatEntity queryObject(Integer id){
		return seatDao.queryObject(id);
	}
	
	@Override
	public List<SeatEntity> queryList(Map<String, Object> map){
		return seatDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return seatDao.queryTotal(map);
	}
	
	@Override
	public void save(SeatEntity seat){
		seatDao.save(seat);
	}
	
	@Override
	public void update(SeatEntity seat){
		seatDao.update(seat);
	}
	
	@Override
	public void delete(Integer id){
		seatDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		seatDao.deleteBatch(ids);
	}
	
}
