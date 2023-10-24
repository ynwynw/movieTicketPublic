package com.wfuhui.modules.advert.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.advert.entity.AdvertEntity;
import com.wfuhui.modules.advert.service.AdvertService;

/**
 * 广告接口
 */
@RestController
@RequestMapping("/api/advert/")
public class ApiAdvertController {
	
	@Autowired
	private AdvertService advertService;

	/**
	 * 列表
	 * @return
	 */
	@AuthIgnore
    @GetMapping("list")
    public R list(){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("enable", 1);
    	params.put("sidx", "sort");
    	params.put("order", "ASC");
    	List<AdvertEntity> advertList = advertService.queryList(params);
        return R.ok().put("advertList", advertList);
    }
}
