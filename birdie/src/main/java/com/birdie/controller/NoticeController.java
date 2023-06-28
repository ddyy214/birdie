package com.birdie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.birdie.logic.NoticeLogic;
import com.util.HashMapBinder;

public class NoticeController  implements Controller {
	Logger logger = Logger.getLogger(NoticeController.class);
	NoticeLogic noticeLogic = new NoticeLogic();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String upmu[] = (String[])req.getAttribute("upmu");
		String page = null;
		int result = 0;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+", "+upmu[1]);
		//-> notice/noticeList.bd
		//공지사항 목록
		if("noticeList".equals(upmu[1])) {
			logger.info("공지사항 목록");
			List<Map<String,Object>> nList = null;
			hmb.bind(pMap);
			nList = noticeLogic.noticeList(pMap);
			req.setAttribute("nList", nList);
			page="forward:notice/noticeList";
		}
		//공지상세 보기 -forward
		else if("noticeDetail".equals(upmu[1])) {
			logger.info("공지상세 보기");
			hmb.bind(pMap);
			List<Map<String,Object>> nList = null;
			nList = noticeLogic.noticeList(pMap);		
			req.setAttribute("nList", nList);
			page="forward:notice/noticeDetail";
		}
		//공지 등록 - POST 방식
		else if("noticeInsert".equals(upmu[1])) {
			logger.info("공지사항 등록");
			hmb.bind(pMap);
			logger.info(pMap); 
			result = noticeLogic.noticeInsert(pMap);
			//입력성공했을때
			if(result ==1) {
				page="redirect:noticeList.bd";
			//실패했을때
			}else{
				page="redirect:noticeError";				
			}
		}
		//공지사항 수정 - POST 방식
 		else if("noticeUpdate".equals(upmu[1])) {
			logger.info("공지사항 수정");
			hmb.bind(pMap);
			result = noticeLogic.noticeUpdate(pMap);
			if(result ==1) {
				page="redirect:noticeList.bd";
			}else{
				page="redirect:noticeError";				
			}			
		}
		else if("noticeDelete".equals(upmu[1])) {
			logger.info("공지사항 삭제");
			hmb.bind(pMap);
			logger.info(pMap);
			result = noticeLogic.noticeDelete(pMap);
			if(result ==1) {
				page="redirect:noticeList.bd";
			}else{
				page="redirect:noticeError";				
			}				
		}
		return page;
	}
}
