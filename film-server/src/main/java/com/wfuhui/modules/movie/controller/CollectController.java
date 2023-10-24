package com.wfuhui.modules.movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.movie.entity.CollectEntity;
import com.wfuhui.modules.movie.service.CollectService;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;




/**
 * 收藏
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@RestController
@RequestMapping("collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CollectEntity> collectList = collectService.queryList(query);
		int total = collectService.queryTotal(query);
		
		return R.ok().put("rows", collectList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		CollectEntity collect = collectService.queryObject(id);
		
		return R.ok().put("collect", collect);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CollectEntity collect){
		collectService.save(collect);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CollectEntity collect){
		collectService.update(collect);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		collectService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
