package com.wfuhui.modules.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wfuhui.common.utils.NumberUtil;
import com.wfuhui.modules.movie.dao.SeatDao;
import com.wfuhui.modules.member.dao.MemberDao;
import com.wfuhui.modules.order.dao.OrderDao;
import com.wfuhui.modules.order.dao.OrderMovieDao;
import com.wfuhui.modules.order.dao.OrderSeatDao;
import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.order.entity.OrderMovieEntity;
import com.wfuhui.modules.order.entity.OrderSeatEntity;
import com.wfuhui.modules.order.service.OrderService;
import com.wfuhui.modules.movie.entity.SeatEntity;


@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderMovieDao orderMovieDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private OrderSeatDao orderSeatDao;
	@Autowired
	private SeatDao seatDao;
	
	@Override
	public OrderEntity queryObject(Integer id){
		OrderEntity order = orderDao.queryObject(id);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", order.getId());
		List<OrderMovieEntity> orderMovieList = orderMovieDao.queryList(params);
		order.setOrderMovieList(orderMovieList);
		order.setMember(memberDao.queryObject(order.getMemberId()));
		order.setOrderSeatList(orderSeatDao.queryList(params));
		return order;
	}
	
	@Override
	public List<OrderEntity> queryList(Map<String, Object> map){
		List<OrderEntity> orderList = orderDao.queryList(map);
		for (OrderEntity order : orderList) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orderId", order.getId());
			List<OrderMovieEntity> orderMovieList = orderMovieDao.queryList(params);
			order.setOrderSeatList(orderSeatDao.queryList(params));
			order.setOrderMovieList(orderMovieList);
		}
		return orderList;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEntity order){
		orderDao.save(order);
	}
	
	@Override
	public void update(OrderEntity order){
		orderDao.update(order);
	}
	
	@Override
	public void delete(Integer orderId){
		orderDao.delete(orderId);
	}
	
	@Override
	public void deleteBatch(Integer[] orderIds){
		orderDao.deleteBatch(orderIds);
	}

	@Override
	@Transactional
	public void createOrder(OrderEntity order) {
		order.setOrderNumber(NumberUtil.getOrderNumber());
		orderDao.save(order);
		List<OrderMovieEntity> orderMovieList = order.getOrderMovieList();
		for (OrderMovieEntity orderMovieEntity : orderMovieList) {
			orderMovieEntity.setOrderId(order.getId());
			orderMovieDao.save(orderMovieEntity);
		}
		
		List<OrderSeatEntity> orderSeatList = order.getOrderSeatList();
		if(orderSeatList != null) {
			for (OrderSeatEntity orderSeat : orderSeatList) {
				orderSeat.setOrderId(order.getId());
				orderSeatDao.save(orderSeat);
				SeatEntity seat = new SeatEntity();
				seat.setStatus(1);
				seat.setId(orderSeat.getSeatId());
				seatDao.update(seat);
			}
		}
	}

	@Override
	public void updateByOrderNumber(OrderEntity order) {
		orderDao.updateByOrderNumber(order);
	}

	@Override
	public List<Map<String, String>> queryOrderCount() {
		return orderDao.queryOrderCount();
	}
	
}
