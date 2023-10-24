package com.wfuhui.modules.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.order.dao.OrderDao;
import com.wfuhui.modules.order.dao.OrderEvaluationDao;
import com.wfuhui.modules.order.dao.OrderMovieDao;
import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.order.entity.OrderEvaluationEntity;
import com.wfuhui.modules.order.entity.OrderMovieEntity;
import com.wfuhui.modules.order.service.OrderEvaluationService;


@Service("orderEvaluationService")
public class OrderEvaluationServiceImpl implements OrderEvaluationService {
	@Autowired
	private OrderEvaluationDao orderEvaluationDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderMovieDao orderMovieDao;
	
	@Override
	public OrderEvaluationEntity queryObject(Integer id){
		return orderEvaluationDao.queryObject(id);
	}
	
	@Override
	public List<OrderEvaluationEntity> queryList(Map<String, Object> map){
		return orderEvaluationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderEvaluationDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEvaluationEntity orderEvaluation){
		OrderEntity order = new OrderEntity();
		if(orderEvaluation.getOrderId() != null) {
			order.setOrderStatus(3);
	    	order.setId(orderEvaluation.getOrderId());
	    	orderDao.update(order);
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("orderId", orderEvaluation.getOrderId());
	    	List<OrderMovieEntity> orderMovieList = orderMovieDao.queryList(map);
	    	for (OrderMovieEntity orderMovie : orderMovieList) {
	    		orderEvaluation.setMovieId(orderMovie.getMovieId());
	    		orderEvaluationDao.save(orderEvaluation);
			}
		}else {
			orderEvaluationDao.save(orderEvaluation);
		}
	}
	
	@Override
	public void update(OrderEvaluationEntity orderEvaluation){
		orderEvaluationDao.update(orderEvaluation);
	}
	
	@Override
	public void delete(Integer id){
		orderEvaluationDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderEvaluationDao.deleteBatch(ids);
	}
	
}
