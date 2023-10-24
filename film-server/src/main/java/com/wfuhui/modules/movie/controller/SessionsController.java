package com.wfuhui.modules.movie.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.movie.entity.SessionsEntity;
import com.wfuhui.modules.movie.service.SessionsService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 场次
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@RestController
@RequestMapping("sessions")
public class SessionsController {
	@Autowired
	private SessionsService sessionsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SessionsEntity> sessionsList = sessionsService.queryList(query);
		int total = sessionsService.queryTotal(query);
		
		return R.ok().put("rows", sessionsList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		SessionsEntity sessions = sessionsService.queryObject(id);
		
		return R.ok().put("sessions", sessions);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SessionsEntity sessions){
		sessions.setCreateTime(new Date());
		sessionsService.save(sessions);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SessionsEntity sessions){
		sessionsService.update(sessions);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		sessionsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
