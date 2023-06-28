package com.birdie.logic;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.birdie.dao.CommentDao;

public class CommentLogic {
	Logger logger = Logger.getLogger(CommentLogic.class);
	private CommentDao commentDao = new CommentDao();
	
	public List<Map<String, Object>> commentList(Map<String, Object> pMap) {
		logger.info("commentList");
		logger.info(pMap);
		List<Map<String,Object>> cList = null;
		cList = commentDao.commentList(pMap);//배달사고 체크, 리턴타입 체크
		return cList;
	}
	public int commentInsert(Map<String, Object> pMap) {
		logger.info("commentInsert");
		logger.info(pMap);
		int result  = -1;//색인- 1:수정 성공, 0이면 수정 실패
		result = commentDao.commentInsert(pMap);
		return result;
	}
	public int commentUpdate(Map<String, Object> pMap) {
		logger.info("commentUpdate");//호출 여부 출력
		logger.info(pMap);//화면에서 작성된 값이 잘 전달 되었나 여부
		int result  = -1;//색인- 1:수정 성공, 0이면 수정 실패
		result = commentDao.commentUpdate(pMap);
		return result;
	}
	public int commentDelete(Map<String, Object> pMap) {
		logger.info("commentDelete");
		logger.info(pMap);
		int result  = -1;//색인- 1:수정 성공, 0이면 수정 실패
		result = commentDao.commentDelete(pMap);
		return result;
	}
}
