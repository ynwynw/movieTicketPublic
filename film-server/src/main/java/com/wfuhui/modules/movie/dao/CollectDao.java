package com.wfuhui.modules.movie.dao;

import com.wfuhui.modules.movie.entity.CollectEntity;
import com.wfuhui.modules.movie.entity.MovieEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 收藏
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@Mapper
public interface CollectDao extends BaseDao<CollectEntity> {
	void remove(@Param("movieId") Integer movieId, @Param("userId") Long userId);

	List<MovieEntity> queryLike(Long userId);
}
