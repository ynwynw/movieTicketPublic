package com.wfuhui.modules.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wfuhui.modules.movie.entity.MovieEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 电影
 * 
 * @author lzl
 * @email 931708230@qq.com
 * @date 2017-07-14 13:43:12
 */
@Mapper
public interface MovieDao extends BaseDao<MovieEntity> {

	void updateStatus(@Param("status")Integer status, @Param("ids")Integer[] ids);

	List<MovieEntity> queryByIds(Integer[] id);
	
	void delStock(@Param("id")Integer id, @Param("stock")int stock);

	void addStock(@Param("id")Integer id, @Param("stock")int stock);
}
