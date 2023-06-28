package com.birdie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class CommentDao {
	Logger logger = Logger.getLogger(CommentDao.class);
	// myBatis Layer 설정 바탕으로 객체 주입이 필요하다
	SqlSessionFactory sqlSessionFactory = null;// 오라클 서버 접속
	SqlSession sqlSession = null;// 커밋과 롤백 담당

	public CommentDao() {// 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}// end of commentDao

	public List<Map<String, Object>> commentList(Map<String, Object> pMap) {
		logger.info("commentList");
		List<Map<String, Object>> cList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			cList = sqlSession.selectList("commentList", pMap);
			logger.info(cList);
		} catch (Exception e) {
			e.printStackTrace();// 에러메시지와 라인번호까지 같이 출력
		}
		return cList;
	}// end of commentList

	public int commentInsert(Map<String, Object> pMap) {
		logger.info("commentInsert");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.insert("commentInsert", pMap);
			logger.info("반환값 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of commentInsert
		// 댓글수정처리

	public int commentUpdate(Map<String, Object> pMap) {
		logger.info("commentUpdate");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("commentUpdate", pMap);
			logger.info("반환값 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of commentUpdate
		// 댓글삭제처리
	public int commentDelete(Map<String, Object> pMap) {
		logger.info("commentDelete");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("commentDelete", pMap);
			logger.info("반환값 : " + result);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of commentDelete

}
