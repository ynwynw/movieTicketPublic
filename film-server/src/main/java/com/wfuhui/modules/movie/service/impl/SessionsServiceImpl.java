package com.wfuhui.modules.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.movie.dao.MovieDao;
import com.wfuhui.modules.movie.dao.SeatDao;
import com.wfuhui.modules.movie.dao.SessionsDao;
import com.wfuhui.modules.movie.entity.SeatEntity;
import com.wfuhui.modules.movie.entity.SessionsEntity;
import com.wfuhui.modules.movie.service.SessionsService;
import com.wfuhui.modules.store.dao.StoreDao;



@Service("sessionsService")
public class SessionsServiceImpl implements SessionsService {
	@Autowired
	private SessionsDao sessionsDao;
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private StoreDao storeDao;
	
	@Override
	public SessionsEntity queryObject(Integer id){
		SessionsEntity sessions = sessionsDao.queryObject(id);
		List<SeatEntity> seatList = seatDao.queryBySessionsId(id);
		sessions.setSeatList(seatList);
		sessions.setMovie(movieDao.queryObject(sessions.getMovieId()));
		sessions.setStore(storeDao.queryObject(sessions.getStoreId()));
		return sessions;
	}
	
	@Override
	public List<SessionsEntity> queryList(Map<String, Object> map){
		return sessionsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sessionsDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(SessionsEntity sessions){
		sessionsDao.save(sessions);
		
		int x = sessions.getColumns();
		int y = sessions.getRows();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				SeatEntity seat = new SeatEntity();
				seat.setStoreId(sessions.getStoreId());
				seat.setMovieId(sessions.getMovieId());
				seat.setSessionsId(sessions.getId());
				seat.setStatus(0);
				seat.setXcoord(j+1);
				seat.setYcoord(i+1);
				seatDao.save(seat);
			}
		}
	}
	
	@Override
	public void update(SessionsEntity sessions){
		sessionsDao.update(sessions);
	}
	
	@Override
	public void delete(Integer id){
		sessionsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sessionsDao.deleteBatch(ids);
	}
	
}
