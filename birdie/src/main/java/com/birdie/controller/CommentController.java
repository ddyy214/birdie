package com.birdie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.birdie.logic.CommentLogic;
import com.util.HashMapBinder;

public class CommentController implements Controller{
	Logger logger = Logger.getLogger(PayController.class);
	private CommentLogic commentLogic = new CommentLogic();
	//리턴타입을 통해서 redirect와 forward여부를 결정짓고 필요한 페이지까지도 요청할 수 있다.
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String[] upmu = (String[])req.getAttribute("upmu");
		String page = null;
		int result = 0;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+", "+upmu[1]);
		
		//댓글조회
		if("commentList".equals(upmu[1])) {
			logger.info("commentList");
			List<Map<String,Object>> cList = null;
			hmb.bind(pMap);
			cList = commentLogic.commentList(pMap);
			req.setAttribute("cList", cList);
			page="forward:comment/commentList";
		}
		//댓글쓰기
		else if("commentInsert".equals(upmu[1])) {
			logger.info("commentInsert");
			hmb.bind(pMap);
			logger.info(pMap); 
			result = commentLogic.commentInsert(pMap);
			//입력 성공한 경우
			if(result==1) {
				page="redirect:commentList.bd"; //오라클경유함
			}
			//실패한경우
			else{
				page="redirect:commentError.jsp";
			}
		}
		//댓글수정 - POST방식 - 내용이 기니까
		else if("commentUpdate".equals(upmu[1])) {
			logger.info("commentUpdate");
			hmb.bind(pMap);
			logger.info(pMap);
			result = commentLogic.commentUpdate(pMap);
			//입력 성공한 경우
			if(result==1) {
				page="redirect:commentList.bd";
			}//실패한경우
			else{
				page="redirect:commentError.jsp";
			}	
		}
		//댓글삭제
		else if("commentDelete".equals(upmu[1])) {
			logger.info("commentDelete");
			hmb.bind(pMap);
			logger.info(pMap);
			result = 0;
			result = commentLogic.commentDelete(pMap);
			//삭제 성공한 경우
			if(result==1) {
				page="redirect:commentList.bd";
			}//실패한경우
			else{
			page="redirect:commentError.jsp";
			}				
		}
		return page;
	}
}
