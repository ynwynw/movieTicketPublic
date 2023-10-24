package com.wfuhui.modules.store.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.store.entity.StoreEntity;
import com.wfuhui.modules.store.service.StoreService;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;


/**
 * 影院
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@RestController
@RequestMapping("store")
public class StoreController{
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<StoreEntity> storeList = storeService.queryList(params);
		return R.ok().put("storeList", storeList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<StoreEntity> storeList = storeService.queryList(query);
		int total = storeService.queryTotal(query);
		
		return R.ok().put("rows", storeList).put("total", total);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		StoreEntity store = storeService.queryObject(id);
		
		return R.ok().put("store", store);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody StoreEntity store){
		store.setCreateTime(new Date());
		storeService.save(store);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody StoreEntity store){
		storeService.update(store);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		storeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
