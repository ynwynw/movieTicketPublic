package com.wfuhui.modules.movie.entity;

import java.io.Serializable;

/**
 * 电影图片
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public class MoviePicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 电影ID
	private Integer movieId;
	// 图片
	private String picUrl;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：电影ID
	 */
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	/**
	 * 获取：电影ID
	 */
	public Integer getMovieId() {
		return movieId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
