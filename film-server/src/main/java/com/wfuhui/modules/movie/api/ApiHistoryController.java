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
import com.wfuhui.modules.movie.entity.HistoryEntity;
import com.wfuhui.modules.movie.service.HistoryService;

/**
 * 分类接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/history")
public class ApiHistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	/**
	 * 列表
	 * @return
	 */
    @GetMapping("save")
    public R save(@RequestBody HistoryEntity history, @RequestAttribute("userId") Long userId){
    	history.setCreateTime(new Date());
    	history.setMemberId(userId);
    	historyService.save(history);
        return R.ok();
    }
}
