package com.wfuhui.modules.movie.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.movie.entity.SessionsEntity;
import com.wfuhui.modules.movie.service.SessionsService;

/**
 * 场次接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/sessions")
public class ApiSesssionsController {
	
	@Autowired
	private SessionsService sessionsService;
	
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	@AuthIgnore
	@GetMapping("list")
    public R list(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
    	List<SessionsEntity> sessionsList = sessionsService.queryList(query);
    	Integer total = sessionsService.queryTotal(map);
        return R.ok().put("sessionsList", sessionsList).put("total", total);
    }
    
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@AuthIgnore
    @GetMapping("detail")
    public R detail(int id){
    	SessionsEntity sessions = sessionsService.queryObject(id);
    	return R.ok().put("sessions", sessions);
    }
	
	
}
