package com.wfuhui.modules.movie.dao;

import com.wfuhui.modules.movie.entity.SeatEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 座位
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
@Mapper
public interface SeatDao extends BaseDao<SeatEntity> {

	List<SeatEntity> queryByMovieId(Integer id);

	List<SeatEntity> queryBySessionsId(Integer id);
	
}
