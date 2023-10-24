package com.wfuhui.modules.movie.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.movie.entity.CategoryEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 分类
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {

	
}
