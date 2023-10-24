package com.wfuhui.modules.movie.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.movie.entity.MovieEntity;
import com.wfuhui.modules.movie.service.MovieService;


/**
 * 电影
 * 
 * @author lzl
 * @email 931708230@qq.com
 * @date 2017-07-14 13:43:12
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据

		List<MovieEntity> movieList = movieService.queryList(params);
		
		return R.ok().put("movieList", movieList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MovieEntity> movieList = movieService.queryList(query);
		int total = movieService.queryTotal(query);
		
		return R.ok().put("rows", movieList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		MovieEntity movie = movieService.queryObject(id);
		
		return R.ok().put("movie", movie);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody MovieEntity movie){
		movie.setCreateTime(new Date());
		movieService.save(movie);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody MovieEntity movie){
		movieService.update(movie);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		movieService.deleteBatch(ids);
		
		return R.ok();
	}
	
    @RequestMapping("/lower")
    public R lower(@RequestBody Integer[] ids) {
    	movieService.updateStatus(0, ids);
    	return R.ok();
    }
    
    @RequestMapping("/upper")
    public R upper(@RequestBody Integer[] ids) {
    	movieService.updateStatus(1, ids);
    	return R.ok();
    }
	
	@RequestMapping("/getAll")
	public R getAll() {
		List<MovieEntity> movieList = movieService.queryList(null);
		return R.ok().put("movieList", movieList);
	}
	
}
