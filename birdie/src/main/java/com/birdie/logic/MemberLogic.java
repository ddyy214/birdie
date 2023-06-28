package com.birdie.logic;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.birdie.dao.MemberDao;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	private MemberDao memberDao = new MemberDao();
	
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList");
		List<Map<String,Object>> mList = null;
		mList = memberDao.memberList(pMap);//배달사고 체크, 리턴타입 체크
		return mList;
	}
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert");
		logger.info(pMap);
		int result  = -1;//색인- 1:수정 성공, 0이면 수정 실패
		result = memberDao.memberInsert(pMap);
		return result;
	}
	public int memberUpdate(Map<String, Object> pMap) {
		logger.info("memberUpdate");//호출 여부 출력
		logger.info(pMap);//화면에서 작성된 값이 잘 전달 되었나 여부
		int result  = -1;//색인- 1:수정 성공, 0이면 수정 실패
		result = memberDao.memberUpdate(pMap);
		return result;
	}
	public int memberDelete(Map<String, Object> pMap) {
		logger.info("memberDelete");
		logger.info(pMap);
		int result  = -1;//색인- 1:수정 성공, 0이면 수정 실패
		result = memberDao.memberDelete(pMap);
		return result;
	}
}
