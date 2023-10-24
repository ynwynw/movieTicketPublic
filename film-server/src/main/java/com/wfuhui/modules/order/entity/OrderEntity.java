package com.wfuhui.modules.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.wfuhui.modules.member.entity.MemberEntity;

/**
 * 订单
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 订单编号
	private String orderNumber;
	// 订单金额
	private BigDecimal totalAmount;
	// 订单状态，1：待付款，2：待发货，3：待收货，4：已完成
	private Integer orderStatus;
	// 创建时间
	private Date createTime;

	private List<OrderMovieEntity> orderMovieList;

	private Long memberId;

	// 备注
	private String remark;

	//物流
	private String courierNum;
	
	//
	private MemberEntity member;
	
	private List<OrderSeatEntity> orderSeatList;
	

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
	 * 设置：订单编号
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * 获取：订单编号
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 设置：订单状态，1：待付款，2：待发货，3：待收货，4：已完成
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * 获取：订单状态，1：待付款，2：待发货，3：待收货，4：已完成
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public List<OrderMovieEntity> getOrderMovieList() {
		return orderMovieList;
	}

	public void setOrderMovieList(List<OrderMovieEntity> orderMovieList) {
		this.orderMovieList = orderMovieList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public List<OrderSeatEntity> getOrderSeatList() {
		return orderSeatList;
	}

	public void setOrderSeatList(List<OrderSeatEntity> orderSeatList) {
		this.orderSeatList = orderSeatList;
	}

}
