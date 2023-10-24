package com.wfuhui.modules.order.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单座位
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public class OrderSeatEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//订单id
	private Integer orderId;
	//电影id
	private Integer movieId;
	//座位id
	private Integer seatId;
	//座位名称
	private String seatName;
	
	private Integer sessionsId;
	
	private String sessionsName;

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
	 * 设置：订单id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getOrderId() {
		return orderId;
	}
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	/**
	 * 设置：座位id
	 */
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	/**
	 * 获取：座位id
	 */
	public Integer getSeatId() {
		return seatId;
	}
	/**
	 * 设置：座位名称
	 */
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	/**
	 * 获取：座位名称
	 */
	public String getSeatName() {
		return seatName;
	}
	
	public Integer getSessionsId() {
		return sessionsId;
	}
	
	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}
	
	public String getSessionsName() {
		return sessionsName;
	}
	
	public void setSessionsName(String sessionsName) {
		this.sessionsName = sessionsName;
	}
	
}
