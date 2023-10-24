package com.wfuhui.modules.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.DateUtils;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.movie.service.MovieService;
import com.wfuhui.modules.member.service.MemberService;
import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.order.service.OrderService;


/**
 * 订单
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private MemberService memberService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderEntity> orderList = orderService.queryList(query);
		int total = orderService.queryTotal(query);
		
		return R.ok().put("rows", orderList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		OrderEntity order = orderService.queryObject(id);
		return R.ok().put("order", order);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody OrderEntity order){
		orderService.save(order);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody OrderEntity order){
		orderService.update(order);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		orderService.deleteBatch(ids);
		
		return R.ok();
	}
	
	/**
	 * 发货
	 */
	@RequestMapping("/sendMovie/{orderId}")
	public R sendMovie(@PathVariable("orderId")Integer orderId, String courierNum) {
		OrderEntity order = new OrderEntity();
		order.setId(orderId);
		order.setOrderStatus(3);
		order.setCourierNum(courierNum);
		orderService.update(order);
		return R.ok();
	}
	
}
