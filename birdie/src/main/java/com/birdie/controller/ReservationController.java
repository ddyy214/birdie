package com.birdie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.birdie.logic.ReservationLogic;
import com.util.HashMapBinder;

public class ReservationController  implements Controller{
	Logger logger = Logger.getLogger(ReservationController.class);
	ReservationLogic reservationLogic = new ReservationLogic();
	//page ="forward:XXXX/XXXX"; 로 끝나고
	//page ="redirect:reservationList.bd"; 로 끝남
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String upmu[] = (String[])req.getAttribute("upmu");
		String page = null;
		int result = 0;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+", "+upmu[1]);
		
		if("reservationList".equals(upmu[1])) {
			logger.info("예약 목록");
			List<Map<String,Object>> rList = null;
			hmb.bind(pMap);
			rList = reservationLogic.reservationList(pMap);
			req.setAttribute("rList", rList);
			page="forward:reservation/reservationList";
		}
		else if("reservationDetail".equals(upmu[1])) {
			logger.info("예약 내역");
			hmb.bind(pMap);
			List<Map<String,Object>> rList = null;
			rList = reservationLogic.reservationList(pMap);		
			req.setAttribute("rList", rList);
			page="forward:reservation/reservationDetail";
		}
		else if("reservationInsert".equals(upmu[1])) {
			logger.info("예약 등록");
			hmb.bind(pMap);
			logger.info(pMap); 
			result = reservationLogic.reservationInsert(pMap);
			if(result ==1) {
				page="redirect:reservationList.bd";
			}else{
				page="redirect:reservationError";				
			}
		}
		else if("reservationUpdate".equals(upmu[1])) {
			logger.info("예약 수정");
			hmb.bind(pMap);
			logger.info(pMap);
			result = reservationLogic.reservationUpdate(pMap);
			if(result ==1) {
				page="redirect:reservationList.bd";
			}else{
				page="redirect:reservationError";				
			}			
		}
		else if("reservationDelete".equals(upmu[1])) {
			logger.info("예약 삭제");
			hmb.bind(pMap);
			logger.info(pMap);
			result = reservationLogic.reservationDelete(pMap);
			if(result ==1) {
				page="redirect:reservationList.bd";
			}else{
				page="redirect:reservationError";				
			}				
		}
		return page;
	}

}
