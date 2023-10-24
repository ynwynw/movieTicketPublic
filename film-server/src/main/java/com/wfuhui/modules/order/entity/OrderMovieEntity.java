package com.wfuhui.modules.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public class OrderMovieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 订单ID
	private Integer orderId;
	// 电影ID
	private Integer movieId;

	private Integer num;

	private String picUrl;

	private BigDecimal price;

	private String movieName;

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
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
