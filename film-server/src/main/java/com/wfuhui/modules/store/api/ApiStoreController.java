package com.wfuhui.modules.store.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.store.entity.StoreEntity;
import com.wfuhui.modules.store.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class ApiStoreController {
	
	@Autowired
	private StoreService storeService;
	
    @AuthIgnore
    @GetMapping("list")
    public R list(){
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("sidx", "sort");
    	params.put("order", "ASC");
    	
    	List<StoreEntity> storeList = storeService.queryList(params);
        return R.ok().put("storeList", storeList);
    }
    
    @AuthIgnore
    @GetMapping("detail")
    public R detail(Integer id) {
    	StoreEntity store = storeService.queryObject(id);
    	return R.ok().put("store", store);
    }
}
