package com.wfuhui.modules.movie.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.movie.entity.MoviePicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 电影图片
 * 
 * @author lzl
 * @email 931708230@qq.com
 * @date 2017-07-14 13:43:12
 */
@Mapper
public interface MoviePicDao extends BaseDao<MoviePicEntity> {

	String[] queryByMovieId(Integer movieId);

	void deleteByMovieId(Integer movieId);
	
}
