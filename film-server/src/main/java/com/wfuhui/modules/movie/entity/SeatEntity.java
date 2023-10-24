package com.wfuhui.modules.movie.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 座位
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public class SeatEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//电影id
	private Integer movieId;
	//横坐标
	private Integer xcoord;
	//纵坐标
	private Integer ycoord;
	//状态
	private Integer status;
	
	private String type;
	
	private Integer storeId;
	
	private Integer sessionsId;

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
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	/**
	 * 设置：横坐标
	 */
	public void setXcoord(Integer xcoord) {
		this.xcoord = xcoord;
	}
	/**
	 * 获取：横坐标
	 */
	public Integer getXcoord() {
		return xcoord;
	}
	/**
	 * 设置：纵坐标
	 */
	public void setYcoord(Integer ycoord) {
		this.ycoord = ycoord;
	}
	/**
	 * 获取：纵坐标
	 */
	public Integer getYcoord() {
		return ycoord;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	
	public String getType() {
		return "danren";
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public Integer getSessionsId() {
		return sessionsId;
	}
	
	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}
	
}
