package com.wfuhui.modules.order.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.order.entity.OrderEntity;

/**
 * 订单
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public interface OrderService {
	
	OrderEntity queryObject(Integer id);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEntity order);
	
	void update(OrderEntity order);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void createOrder(OrderEntity orderEntity);

	void updateByOrderNumber(OrderEntity order);

	List<Map<String, String>> queryOrderCount();
}
