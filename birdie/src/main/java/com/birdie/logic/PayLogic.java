package com.birdie.logic;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.birdie.dao.PayDao;

public class PayLogic {
	Logger logger = Logger.getLogger(PayLogic.class);
	private PayDao payDao = new PayDao();
	
	public List<Map<String, Object>> payList(Map<String, Object> pMap) {
		logger.info("payList");
		List<Map<String, Object>> pList = null;
		pList = payDao.payList(pMap);
		return pList;
	}
	public int payInsert(Map<String, Object> pMap) {
		logger.info("payInsert");
		logger.info(pMap);
		int result = 0;
		result = payDao.payInsert(pMap);
		return result;
	}
	public int payDelete(Map<String, Object> pMap) {
		logger.info("payDelete");
		logger.info(pMap);
		int result = 0;
		result = payDao.payDelete(pMap);
		return result;
	}
}
