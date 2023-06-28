package com.birdie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class PayDao {

	Logger logger = Logger.getLogger(PayDao.class);
	SqlSessionFactory sqlSessionFactory = null;// 오라클 서버 접속
	SqlSession sqlSession = null;// 커밋과 롤백 담당

	public PayDao() {// 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}// end of PayDao
	//결제내역
	public List<Map<String, Object>> payList(Map<String, Object> pMap) {
		logger.info("payList");
		List<Map<String, Object>> pList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			pList = sqlSession.selectList("payList", pMap);
			logger.info(pList);
		} catch (Exception e) {
			e.printStackTrace();// 에러메시지와 라인번호까지 같이 출력
		}
		return pList;
	}// end of payList
	//결제하기
	public int payInsert(Map<String, Object> pMap) {
		logger.info("payInsert");
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("payInsert", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of payInsert
		//결제취소
	public int payDelete(Map<String, Object> pMap) {
		logger.info("payDelete");
		int result = 0;
		// mybatis가 제공하는 SqlSessionFactory는 물리적으로 떨어져 있는 오라클 서버와 연결
		sqlSession = sqlSessionFactory.openSession();
		try {
			// SqlSession객체는 SqlSessionFactory가 먼저 생성되어야 생성가능
			// 역할: selectList, insert, update, delete제공
			result = sqlSession.delete("payDelete", pMap);
			// insert, update, delete는 커밋과 롤백에 대상이므로 반드시 커밋을 요청해야 물리적인 테이블 반영됨
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of payDelete

}
