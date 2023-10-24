package com.wfuhui.modules.movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.movie.entity.SeatEntity;
import com.wfuhui.modules.movie.service.SeatService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;



/**
 * 座位
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@RestController
@RequestMapping("seat")
public class SeatController {
	@Autowired
	private SeatService seatService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SeatEntity> seatList = seatService.queryList(query);
		int total = seatService.queryTotal(query);
		
		return R.ok().put("rows", seatList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		SeatEntity seat = seatService.queryObject(id);
		
		return R.ok().put("seat", seat);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SeatEntity seat){
		seatService.save(seat);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SeatEntity seat){
		seatService.update(seat);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		seatService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
