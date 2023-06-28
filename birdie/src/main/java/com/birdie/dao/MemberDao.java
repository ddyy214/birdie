package com.birdie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class MemberDao {

	Logger logger = Logger.getLogger(MemberDao.class);
	// myBatis Layer 설정 바탕으로 객체 주입이 필요하다
	SqlSessionFactory sqlSessionFactory = null;// 오라클 서버 접속
	SqlSession sqlSession = null;// 커밋과 롤백 담당

	public MemberDao() {// 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}// end of MemberDao
		// 회원목록
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList");
		List<Map<String, Object>> mList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			mList = sqlSession.selectList("memberList", pMap);
			logger.info(mList);
		} catch (Exception e) {
			e.printStackTrace();// 에러메시지와 라인번호까지 같이 출력
		}
		return mList;
	}// end of memberList
		// 회원가입
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert");
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("memberInsert", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of memberInsert
		// 회원정보 수정
	public int memberUpdate(Map<String, Object> pMap) {
		logger.info("memberUpdate");
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.update("memberUpdate", pMap);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of memberUpdate
		// 회원정보 삭제
	public int memberDelete(Map<String, Object> pMap) {
		logger.info("memberDelete");
		int result = 0;
		// mybatis가 제공하는 SqlSessionFactory는 물리적으로 떨어져 있는 오라클 서버와 연결
		sqlSession = sqlSessionFactory.openSession();
		try {
			// SqlSession객체는 SqlSessionFactory가 먼저 생성되어야 생성가능
			// 역할: selectList, insert, update, delete제공
			result = sqlSession.delete("memberDelete", pMap);
			// insert, update, delete는 커밋과 롤백에 대상이므로 반드시 커밋을 요청해야 물리적인 테이블 반영됨
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}// end of memberDelete

}
