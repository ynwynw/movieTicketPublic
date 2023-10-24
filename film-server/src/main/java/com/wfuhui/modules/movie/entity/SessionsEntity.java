package com.wfuhui.modules.movie.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.bouncycastle.pqc.math.linearalgebra.BigEndianConversions;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wfuhui.modules.store.entity.StoreEntity;



/**
 * 场次
 * 
 * @author lizhengle
 * @email 931708230@qq.com
 */
public class SessionsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//电影id
	private Integer movieId;
	//发布日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date releaseDate;
	//创建时间
	private Date createTime;
	
	private Integer storeId;
	
	private StoreEntity store;
	
	private MovieEntity movie;
	
	private List<SeatEntity> seatList;
	
	//影厅
	private String cinema;
	
	private BigDecimal price;
	
	private Integer rows;
	
	private Integer columns;

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
	 * 设置：电影id
	 */
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	/**
	 * 获取：电影id
	 */
	public Integer getMovieId() {
		return movieId;
	}
	/**
	 * 设置：发布日期
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * 获取：发布日期
	 */
	public Date getReleaseDate() {
		return releaseDate;
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
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public StoreEntity getStore() {
		return store;
	}
	
	public void setStore(StoreEntity store) {
		this.store = store;
	}
	
	public MovieEntity getMovie() {
		return movie;
	}
	
	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
	
	public List<SeatEntity> getSeatList() {
		return seatList;
	}
	
	public void setSeatList(List<SeatEntity> seatList) {
		this.seatList = seatList;
	}
	
	public String getCinema() {
		return cinema;
	}
	
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getRows() {
		return rows;
	}
	
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getColumns() {
		return columns;
	}
	
	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	
	
}
