package com.wfuhui.modules.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.order.dao.OrderSeatDao;
import com.wfuhui.modules.order.entity.OrderSeatEntity;
import com.wfuhui.modules.order.service.OrderSeatService;



@Service("orderSeatService")
public class OrderSeatServiceImpl implements OrderSeatService {
	@Autowired
	private OrderSeatDao orderSeatDao;
	
	@Override
	public OrderSeatEntity queryObject(Integer id){
		return orderSeatDao.queryObject(id);
	}
	
	@Override
	public List<OrderSeatEntity> queryList(Map<String, Object> map){
		return orderSeatDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderSeatDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderSeatEntity orderSeat){
		orderSeatDao.save(orderSeat);
	}
	
	@Override
	public void update(OrderSeatEntity orderSeat){
		orderSeatDao.update(orderSeat);
	}
	
	@Override
	public void delete(Integer id){
		orderSeatDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderSeatDao.deleteBatch(ids);
	}
	
}
