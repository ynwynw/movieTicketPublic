package com.wfuhui.modules.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 订单
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {

	void updateByOrderNumber(OrderEntity order);

	List<Map<String, String>> queryOrderCount();
	
}
