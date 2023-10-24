package com.wfuhui.modules.movie.dao;

import com.wfuhui.modules.movie.entity.HistoryEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 浏览记录
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@Mapper
public interface HistoryDao extends BaseDao<HistoryEntity> {

	List<HistoryEntity> queryByUserId(Long userId);

	List<HistoryEntity> queryByMovieId(Integer movieId);
	
}
