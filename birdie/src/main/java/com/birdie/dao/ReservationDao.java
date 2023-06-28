package com.birdie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class ReservationDao {
	Logger logger = Logger.getLogger(ReservationDao.class);
	// myBatis Layer 설정 바탕으로 객체 주입이 필요하다
	SqlSessionFactory sqlSessionFactory = null;// 오라클 서버 접속
	SqlSession sqlSession = null;// 커밋과 롤백 담당

	public ReservationDao() {// 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}// end of reservationDao

	public List<Map<String, Object>> reservationList(Map<String, Object> pMap) {
		logger.info("reservationList");
		List<Map<String, Object>> rList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			rList = sqlSession.selectList("reservationList", pMap);
			logger.info(rList);
		} catch (Exception e) {
			e.printStackTrace();// 에러메시지와 라인번호까지 같이 출력
		}
		return rList;
	}// end of reservationList
	//예약하기
	public int reservationInsert(Map<String, Object> pMap) {
		logger.info("reservationInsert");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.insert("reservationInsert", pMap);
			logger.info("반환값 :"+result);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of reservationInsert
		// 예약수정
	public int reservationUpdate(Map<String, Object> pMap) {
		logger.info("reservationUpdate");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("reservationUpdate", pMap);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of reservationUpdate
		//예약취소
	public int reservationDelete(Map<String, Object> pMap) {
		logger.info("reservationDelete");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("reservationDelete", pMap);
			logger.info("반환값 :"+result);
			sqlSession.commit();
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of reservationDelete

}
