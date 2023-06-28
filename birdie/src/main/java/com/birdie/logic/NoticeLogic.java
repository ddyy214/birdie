package com.birdie.logic;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.birdie.dao.NoticeDao;


public class NoticeLogic {
	Logger logger = Logger.getLogger(NoticeLogic.class);
	private NoticeDao noticeDao = new NoticeDao();//이른 인스턴스화
	
	public List<Map<String, Object>> noticeList(Map<String, Object> pMap) {
		logger.info("noticeList");//시간과 클래스명, 라인번호
		List<Map<String, Object>> nList = null;
		nList = noticeDao.noticeList(pMap);//조회결과가 없더라도 myBatis레이어에서 주입
		return nList;
	}
	public int noticeInsert(Map<String, Object> pMap) {
		logger.info("noticeInsert");
		logger.info(pMap);
		int result = 0;
		result = noticeDao.noticeInsert(pMap);
		return result;
	}
	public int noticeUpdate(Map<String, Object> pMap) {
		logger.info("noticeUpdate");
		logger.info(pMap);
		int result = 0;
		result = noticeDao.noticeUpdate(pMap);
		return result;
	}
	public int noticeDelete(Map<String, Object> pMap) {
		logger.info("noticeDelete");
		logger.info(pMap);
		int result = 0;
		result = noticeDao.noticeDelete(pMap);
		return result;
	}
}
