package com.birdie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.birdie.logic.QnaLogic;
import com.util.HashMapBinder;

//게시판
public class QnaController  implements Controller{
	Logger logger = Logger.getLogger(QnaController.class);
	private QnaLogic qnaLogic = new QnaLogic();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String[] upmu = (String[])req.getAttribute("upmu");
		String page = null;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+", "+upmu[1]);
		
		if("qnaList".equals(upmu[1])) {
			logger.info("QnA 목록");
			List<Map<String,Object>> qList = null;
			hmb.bind(pMap);
			qList = qnaLogic.qnaList(pMap);
			req.setAttribute("qList", qList);
			page="forward:qna/qnaList";
		}
		//상세보기
		else if("qnaDetail".equals(upmu[1])) {
			logger.info("QnA 내역");
			hmb.bind(pMap);
			List<Map<String,Object>> qList = null;
			qList = qnaLogic.qnaList(pMap);		
			req.setAttribute("qList", qList);
			page="forward:qna/qnaDetail";
		}
		else if("qnaInsert".equals(upmu[1])) {
			logger.info("QnA 등록");
			int result = 0;
			hmb.bind(pMap);
			logger.info(pMap); 
			result = qnaLogic.qnaInsert(pMap);
			if(result ==1) {
				page="redirect:qna/qnaList.bd";
			}else{
				page="redirect:qnaError.jsp";				
			}
		}
		//수정하기 - POST방식
		else if("qnaUpdate".equals(upmu[1])) {
			logger.info("QnA 수정");
			hmb.bind(pMap);
			logger.info(pMap);
			int result = 0;
			result = qnaLogic.qnaUpdate(pMap);
			if(result ==1) {
				page="redirect:qna/qnaList.bd";
			}else{
				page="redirect:qnaError.jsp";				
			}			
		}
		else if("qnaDelete".equals(upmu[1])) {
			logger.info("QnA 삭제");
			hmb.bind(pMap);
			logger.info(pMap);
			int result = 0;
			result = qnaLogic.qnaDelete(pMap);
			if(result ==1) {
				page="redirect:qna/qnaList.bd";
			}else{
				page="redirect:qnaError.sjp";				
			}				
		}
		return page;
	}
}
