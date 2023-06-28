package com.birdie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.birdie.logic.PayLogic;
import com.util.HashMapBinder;

public class PayController  implements Controller{
	Logger logger = Logger.getLogger(PayController.class);
	private PayLogic payLogic = new PayLogic();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute");
		String[] upmu = (String[])req.getAttribute("upmu");
		String page = null;
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		logger.info(upmu[0]+", "+upmu[1]);
		
		if("payList".equals(upmu[1])) {
			logger.info("결제 목록");
			List<Map<String,Object>> pList = null;
			hmb.bind(pMap);
			pList = payLogic.payList(pMap);
			req.setAttribute("pList", pList);
			page="forward:pay/payList";
		}
		else if("payDetail".equals(upmu[1])) {
			logger.info("결제 내역");
			hmb.bind(pMap);
			List<Map<String,Object>> pList = null;
			pList = payLogic.payList(pMap);		
			req.setAttribute("pList", pList);
			page="forward:pay/payDetail";
		}
		else if("payInsert".equals(upmu[1])) {
			logger.info("결제하기");
			int result = 0;
			hmb.bind(pMap);
			logger.info(pMap); 
			result = payLogic.payInsert(pMap);
			if(result ==1) {
				page="redirect:payList.bd";
			}else{
				page="redirect:payError";				
			}
		}
		else if("payDelete".equals(upmu[1])) {
			logger.info("결제취소");
			int result = 0;
			hmb.bind(pMap);
			result = payLogic.payDelete(pMap);
			if(result ==1) {
				page="redirect:payList.bd";
			}else{
				page="redirect:payError";				
			}				
		}
		return page;
	}
}
