package com.birdie.logic;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.birdie.dao.QnaDao;

public class QnaLogic {
	Logger logger = Logger.getLogger(QnaLogic.class);
	private QnaDao qnaDao = new QnaDao();
	
	public List<Map<String, Object>> qnaList(Map<String, Object> pMap) {
		logger.info("qnaList");
		List<Map<String, Object>> qList = null;
		qList = qnaDao.qnaList(pMap);
		return qList;
	}
	public int qnaInsert(Map<String, Object> pMap) {
		logger.info("qnaInsert");
		logger.info(pMap);
		int result = -1;
		result = qnaDao.qnaInsert(pMap);
		return result;
	}
	public int qnaUpdate(Map<String, Object> pMap) {
		logger.info("qnaUpdate");
		logger.info(pMap);
		int result = -1;
		result = qnaDao.qnaUpdate(pMap);
		return result;
	}
	public int qnaDelete(Map<String, Object> pMap) {
		logger.info("qnaDelete");
		logger.info(pMap);
		int result = -1;
		result = qnaDao.qnaDelete(pMap);
		return result;
	}
}
