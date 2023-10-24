package com.wfuhui.modules.order.service;

import com.wfuhui.modules.order.entity.OrderSeatEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单座位
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public interface OrderSeatService {
	
	OrderSeatEntity queryObject(Integer id);
	
	List<OrderSeatEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderSeatEntity orderSeat);
	
	void update(OrderSeatEntity orderSeat);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
