package com.birdie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class NoticeDao {
	Logger logger = Logger.getLogger(NoticeDao.class);
	// myBatis 레이어 코드 추가됨.
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;

	public NoticeDao() {// 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}

	public List<Map<String, Object>> noticeList(Map<String, Object> pMap) {
		logger.info("noticeList ==> " + pMap);// {키=값, 키2=값2,.....}
		List<Map<String, Object>> nList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			nList = sqlSession.selectList("noticeList", pMap);
			logger.info(nList);
		} catch (Exception e) {
			e.printStackTrace();// 에러메시지와 라인번호까지 같이 출력
		}
		return nList;
	}

	public int noticeInsert(Map<String, Object> pMap) {
		logger.info("noticeInsert");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.insert("noticeInsert", pMap);
			logger.info("insert문  요청시 오라클서버에서 처리 후에 반환값 : " + result);
			sqlSession.commit();// auto커밋 모드가 꺼져 있어서 반드시 따로 commit()호출해야 반영됨
		} catch (Exception e) {
			logger.info(e.toString());// 발생한 익셉션의 이름만 출력해줌-디버깅하는데 그다지 도움이덜됨
		}
		return result;
	}

	public int noticeUpdate(Map<String, Object> pMap) {
		logger.info("noticeUpdate");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			// 쿼리문을 board.xml에서 id값으로 찾아온다
			// insert로 했을 때 처리가 되기는 하지만 상징성이 있으니까 바꿔서 사용하자
			result = sqlSession.update("noticeUpdate", pMap);
			logger.info("update문  요청시 오라클서버에서 처리 후에 반환값 : " + result);
			sqlSession.commit();// auto커밋 모드가 꺼져 있어서 반드시 따로 commit()호출해야 반영됨
			logger.info(result);// 0 이면 삭제 실패, 1이면 삭제 성공
		} catch (Exception e) {
			logger.info(e.toString());// 발생한 익셉션의 이름만 출력해줌-디버깅하는데 그다지 도움이덜됨
		}

		return result;
	}

	public int noticeDelete(Map<String, Object> pMap) {
		logger.info("noticeDelete");
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			// 쿼리문을 board.xml에서 id값으로 찾아온다
			// insert로 했을 때 처리가 되기는 하지만 상징성이 있으니까 바꿔서 사용하자
			result = sqlSession.delete("noticeDelete", pMap);
			logger.info("delete문  요청시 오라클서버에서 처리 후에 반환값 : " + result);
			sqlSession.commit();// auto커밋 모드가 꺼져 있어서 반드시 따로 commit()호출해야 반영됨
			logger.info(result);// 0 이면 삭제 실패, 1이면 삭제 성공
		} catch (Exception e) {
			logger.info(e.toString());// 발생한 익셉션의 이름만 출력해줌-디버깅하는데 그다지 도움이덜됨
		}
		return result;
	}

}
