package com.wfuhui.modules.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 影院
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public class StoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 影院名称
	private String storeName;
	// 排序
	private Integer sort;

	private String picUrl;

	private Integer status;
	// 创建时间
	private Date createTime;
	
	private String address;
	
	private Double lng;
	
	private Double lat;
	
	private Integer star;

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
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

}
