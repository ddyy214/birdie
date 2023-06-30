package com.birdie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.birdie.logic.MemberLogic;
import com.util.HashMapBinder;
//MemberController가 Controller에 구현체 클래스이다.
public class MemberController implements Controller{
	Logger logger = Logger.getLogger(MemberController.class);
	private MemberLogic memberLogic = new MemberLogic(); //이른 인스턴스화 NullPointException 방지
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String[] upmu = (String[])req.getAttribute("upmu");
		String page = null;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+", "+upmu[1]);
		//회원목록조회
		//SELECT * FROM member WHERE mem_name LIKE ?||'%' AND mem_hp = ? -> 조회결과는 0건이 될수도 1건이 될수도 n건이 될수도
		//그래서 리턴타입은 List<Map<>>
		if("memberList".equals(upmu[1])) {
			logger.info("회원목록조회");
			List<Map<String,Object>> mList = null;
			hmb.bind(pMap);
			mList = memberLogic.memberList(pMap);
			req.setAttribute("mList", mList);
			page="forward:member/memberList"; //응답페이지 이름, select결과가 유지되어야 하니까 forward로 한다
		}
		//회원 상세정보 보기
		else if("memberDetail".equals(upmu[1])) {
			logger.info("회원정보 보기");
			hmb.bind(pMap);
			List<Map<String,Object>> mList = null;
			mList = memberLogic.memberList(pMap);		
			req.setAttribute("mList", mList);
			page="forward:member/memberDetail";
		}
		//회원가입
		else if("memberInsert".equals(upmu[1])) {
			logger.info("회원가입");
			int result = 0;
			hmb.bind(pMap);
			logger.info(pMap); 
			result = memberLogic.memberInsert(pMap);
			//성공시 1
			if(result==1) {
				page="redirect:member/memberList.bd";
				//실패했을때
			}else{
				page="redirect:memberError";				
			}
		}
		else if("memberUpdate".equals(upmu[1])) {
			logger.info("회원정보수정");
			int result = 0;
			hmb.bind(pMap);
			result = memberLogic.memberUpdate(pMap);
			if(result ==1) {
				page="redirect:memberList.bd";
			}else{
				page="redirect:memberError";				
			}			
		}
		else if("memberDelete".equals(upmu[1])) {
			logger.info("회원탈퇴");
			int result = 0;
			hmb.bind(pMap);
			result = memberLogic.memberDelete(pMap);
			if(result ==1) {
				page="redirect:memberList.bd";
			}else{
				page="redirect:memberError";				
			}				
		}
		return page;
	}
}
