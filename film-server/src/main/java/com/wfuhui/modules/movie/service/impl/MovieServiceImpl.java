package com.wfuhui.modules.movie.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.movie.dao.MovieDao;
import com.wfuhui.modules.movie.dao.MoviePicDao;
import com.wfuhui.modules.movie.dao.SeatDao;
import com.wfuhui.modules.movie.dao.HistoryDao;
import com.wfuhui.modules.movie.entity.MovieEntity;
import com.wfuhui.modules.movie.entity.MoviePicEntity;
import com.wfuhui.modules.movie.entity.SeatEntity;
import com.wfuhui.modules.movie.entity.HistoryEntity;
import com.wfuhui.modules.movie.service.MovieService;
import com.wfuhui.modules.member.dao.MemberDao;
import com.wfuhui.modules.member.entity.MemberEntity;


@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private MoviePicDao moviePicDao;
	@Autowired
	private HistoryDao historyDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private SeatDao seatDao;
	
	@Override
	public MovieEntity queryObject(Integer id){
		String[] picUrls = moviePicDao.queryByMovieId(id);
		MovieEntity movie = movieDao.queryObject(id);
		movie.setPicUrls(picUrls);
		List<SeatEntity> seatList = seatDao.queryBySessionsId(id);
		movie.setSeatList(seatList);
		return movie;
	}
	
	@Override
	public List<MovieEntity> queryList(Map<String, Object> map){
		List<MovieEntity> movieList = movieDao.queryList(map);
		return movieList;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return movieDao.queryTotal(map);
	}
	
	@Override
	public void save(MovieEntity movie){
		movieDao.save(movie);
		if (movie.getPicUrls() != null) {
			String[] picUrls = movie.getPicUrls();
			for (String picUrl : picUrls) {
				MoviePicEntity moviePic = new MoviePicEntity();
				moviePic.setMovieId(movie.getId());
				moviePic.setPicUrl(picUrl);
				moviePicDao.save(moviePic);
			}
		}
		/**
		int x = 6;
		int y = 6;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				SeatEntity seat = new SeatEntity();
				seat.setMovieId(movie.getId());
				seat.setStatus(0);
				seat.setXcoord(j+1);
				seat.setYcoord(i+1);
				seatDao.save(seat);
			}
		}*/
	}
	
	@Override
	public void update(MovieEntity movie){
		if (movie.getPicUrls() != null) {
			String[] picUrls = moviePicDao.queryByMovieId(movie.getId());
			boolean e = isQualsPic(picUrls, movie.getPicUrls());
			if (!e) {
				moviePicDao.deleteByMovieId(movie.getId());
				for (String picUrl : movie.getPicUrls()) {
					MoviePicEntity moviePic = new MoviePicEntity();
					moviePic.setMovieId(movie.getId());
					moviePic.setPicUrl(picUrl);
					moviePicDao.save(moviePic);
				}
			}
		}
		movieDao.update(movie);
	}
	
	private boolean isQualsPic(String[] picUrls, String[] picUrls2) {
		if (picUrls.length == picUrls2.length) {
			for (int i = 0; i < picUrls.length; i++) {
				if (!picUrls[i].equals(picUrls2[i])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void delete(Integer id){
		movieDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		movieDao.deleteBatch(ids);
	}
	
	@Override
	public void updateStatus(Integer status, Integer[] ids) {
		movieDao.updateStatus(status, ids);
	}
	
	
	/**
	 * 可能喜欢
	 * */
	@Override
    public List<MovieEntity> getLike(Long userId) {
		
        return new ArrayList<MovieEntity>();
    }
}
