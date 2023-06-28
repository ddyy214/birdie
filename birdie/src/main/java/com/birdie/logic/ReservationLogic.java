package com.birdie.logic;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.birdie.dao.ReservationDao;

public class ReservationLogic {
	Logger logger = Logger.getLogger(ReservationLogic.class);
	private ReservationDao reservationDao = new ReservationDao();
	
	public List<Map<String, Object>> reservationList(Map<String, Object> pMap) {
		logger.info("reservationList");
		List<Map<String, Object>> rList = null;
		rList = reservationDao.reservationList(pMap);
		return rList;
	}
	public int reservationInsert(Map<String, Object> pMap) {
		logger.info("reservationInsert");
		logger.info(pMap);
		int result = -1;
		result = reservationDao.reservationInsert(pMap);
		return result;
	}
	public int reservationUpdate(Map<String, Object> pMap) {
		logger.info("reservationUpdate");
		logger.info(pMap);
		int result = -1;
		result = reservationDao.reservationUpdate(pMap);
		return result;
	}
	public int reservationDelete(Map<String, Object> pMap) {
		logger.info("reservationDelete");
		logger.info(pMap);
		int result = -1;
		result = reservationDao.reservationDelete(pMap);
		return result;
	}
}
