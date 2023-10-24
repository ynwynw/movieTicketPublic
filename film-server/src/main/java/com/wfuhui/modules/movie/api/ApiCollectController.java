package com.wfuhui.modules.movie.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.movie.entity.CollectEntity;
import com.wfuhui.modules.movie.entity.HistoryEntity;
import com.wfuhui.modules.movie.service.CollectService;
import com.wfuhui.modules.movie.service.HistoryService;

/**
 * 分类接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/collect")
public class ApiCollectController {
	
	@Autowired
	private CollectService collectService;
	
	/**
     * 是否点赞
     * @param movieId
     * @param userId
     * @return
     */
    @RequestMapping("/isCollect")
	public R isCollect(Integer movieId, @RequestAttribute Long userId){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("movieId", movieId);
    	map.put("userId", userId);
		int total = collectService.queryTotal(map);
		if(total > 0) {
			return R.ok();
		}
		return R.error();
	}
    
    /**
     * 点赞
     * @param movieId
     * @param userId
     * @return
     */
    @RequestMapping("/collect")
    public R collect(Integer movieId, @RequestAttribute Long userId) {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("movieId", movieId);
    	params.put("userId", userId);
    	Integer total = collectService.queryTotal(params);
    	if(total > 0) {
    		return R.ok();
    	}
    	CollectEntity collect = new CollectEntity();
    	collect.setMovieId(movieId);
    	collect.setCreateTime(new Date());
    	collect.setMemberId(userId);
    	collectService.save(collect);
    	return R.ok();
    }
    
    /**
     * 取消点赞
     * @param movieId
     * @param userId
     * @return
     */
    @RequestMapping("/uncollect")
    public R uncollect(Integer movieId, @RequestAttribute Long userId) {
    	collectService.remove(movieId, userId);
    	return R.ok();
    }
}
