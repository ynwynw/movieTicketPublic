package com.wfuhui.modules.order.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.order.entity.OrderEvaluationEntity;

/**
 * 订单评价
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public interface OrderEvaluationService {
	
	OrderEvaluationEntity queryObject(Integer id);
	
	List<OrderEvaluationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEvaluationEntity orderEvaluation);
	
	void update(OrderEvaluationEntity orderEvaluation);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
