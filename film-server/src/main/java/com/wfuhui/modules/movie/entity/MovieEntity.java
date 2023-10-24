package com.wfuhui.modules.movie.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 电影
 * 
 * @author lzl
 * @email 931708230@qq.com
 */
public class MovieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 电影名称
	private String movieName;
	// 分类ID
	private Integer categoryId;
	// 价格
	private BigDecimal price;

	private String picUrl;
	// 描述
	private String describe;
	// 创建时间
	private Date createTime;

	private String[] picUrls;
	
	//上下架
	private Integer status;
	
	//库存
	private Integer stock;
	
	
	private String director;
	
	private String actor;
	
	private Float score;
	
	private Integer sessionsId;
	
	private List<SeatEntity> seatList;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 分类
	 */
	private CategoryEntity category;
	
	/**
	 * 设置：电影名称
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * 获取：电影名称
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * 设置：分类ID
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获取：分类ID
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置：描述
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	/**
	 * 获取：描述
	 */
	public String getDescribe() {
		return describe;
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String[] getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String[] picUrls) {
		this.picUrls = picUrls;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public List<SeatEntity> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<SeatEntity> seatList) {
		this.seatList = seatList;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}

}
