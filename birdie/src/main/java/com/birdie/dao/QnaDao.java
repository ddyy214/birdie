package com.birdie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class QnaDao {

	Logger logger = Logger.getLogger(QnaDao.class);
	// myBatis Layer 설정 바탕으로 객체 주입이 필요하다
	SqlSessionFactory sqlSessionFactory = null;// 오라클 서버 접속
	SqlSession sqlSession = null;// 커밋과 롤백 담당

	public QnaDao() {// 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}// end of qnaDao

	public List<Map<String, Object>> qnaList(Map<String, Object> pMap) {
		logger.info("qnaList");
		List<Map<String, Object>> qList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			qList = sqlSession.selectList("qnaList", pMap);
			logger.info(qList);
		} catch (Exception e) {
			e.printStackTrace();// 에러메시지와 라인번호까지 같이 출력
		}
		return qList;
	}// end of qnaList

	public int qnaInsert(Map<String, Object> pMap) {
		logger.info("qnaInsert");
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("qnaInsert", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of qnaInsert
		// 회원 정보 수정 처리

	public int qnaUpdate(Map<String, Object> pMap) {
		logger.info("qnaUpdate");
		int result = 0;
		// mybatis가 제공하는 SqlSessionFactory는 물리적으로 떨어져 있는 오라클 서버와 연결
		sqlSession = sqlSessionFactory.openSession();
		try {
			// SqlSession객체는 SqlSessionFactory가 먼저 생성되어야 생성가능
			// 역할: selectList, insert, update, delete제공
			result = sqlSession.update("qnaUpdate", pMap);
			// insert, update, delete는 커밋과 롤백에 대상이므로 반드시 커밋을 요청해야 물리적인 테이블 반영됨
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of qnaUpdate
		// 회원 정보 삭제 처리

	public int qnaDelete(Map<String, Object> pMap) {
		logger.info("qnaDelete");
		int result = 0;
		// mybatis가 제공하는 SqlSessionFactory는 물리적으로 떨어져 있는 오라클 서버와 연결
		sqlSession = sqlSessionFactory.openSession();
		try {
			// SqlSession객체는 SqlSessionFactory가 먼저 생성되어야 생성가능
			// 역할: selectList, insert, update, delete제공
			result = sqlSession.delete("qnaDelete", pMap);
			// insert, update, delete는 커밋과 롤백에 대상이므로 반드시 커밋을 요청해야 물리적인 테이블 반영됨
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of qnaDelete

}
