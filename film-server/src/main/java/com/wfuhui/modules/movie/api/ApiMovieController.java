package com.wfuhui.modules.movie.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.movie.entity.MovieEntity;
import com.wfuhui.modules.movie.service.MovieService;

/**
 * 电影接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/movie")
public class ApiMovieController {
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	@AuthIgnore
	@GetMapping("list")
    public R list(@RequestParam Map<String, Object> map){
		map.put("status", 1);
		Query query = new Query(map);
    	List<MovieEntity> movieList = movieService.queryList(query);
    	Integer total = movieService.queryTotal(map);
        return R.ok().put("movieList", movieList).put("total", total);
    }
    
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@AuthIgnore
    @GetMapping("detail")
    public R detail(int id){
    	MovieEntity movie = movieService.queryObject(id);
    	return R.ok().put("movie", movie);
    }
	
	
	@GetMapping("recommend")
    public R recommend(@RequestAttribute("userId") Long userId){
    	List<MovieEntity> movieList = movieService.getLike(userId);
        return R.ok().put("movieList", movieList);
    }
    
}
