package com.birdie.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ActionServlet  extends HttpServlet{
	Logger logger = Logger.getLogger(ActionServlet.class);
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doService");
		String uri = req.getRequestURI();//요청객체로 넘어온 URI
		logger.info(uri);
		String context = req.getContextPath();
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf("."); 
		command = command.substring(0,end);
		String upmu[] = null;
		//슬래시를 기준으로 문자열을 썰어서 배열에 순서대로 담아줌
		upmu = command.split("/");
		//요청객체에다가 upmu배열의 주소번지를 저장
		//XXXController 에서 if문으로 5가지 경우를 나눠야한다.
		Controller controller = null; //변수 초기화
		String page = null; //변수 초기화
		// http://localhost:9000/member/memberList.bd
		// http://localhost:9000/member/memberInsert.bd
		// http://localhost:9000/member/memberUpdate.bd
		// http://localhost:9000/member/memberDelete.bd
		if("member".equals(upmu[0])) {
			logger.info("member");
			controller = new MemberController();
			//execute메소드를 호출할 때 넘기는 request객체에다가 upmu배열을 저장
			req.setAttribute("upmu", upmu); //저장하기
			//오버라이드된 execute메소드 호출하기
			//컨트롤 클래스는 Controller인터페이스를 implements하고 있다- 추상메소드(execute) 재정의해야함 
			//각 컨트롤러 클래스가 서블릿이 아니어도 되는 건 execute메소드의 파라미터로 요청객체와 응답객체를 받을 수 있기 때문임
			page = controller.execute(req, resp);
		}
		else if("notice".equals(upmu[0])) {
			controller = new NoticeController();
			//요청객체에 String배열의 주소번지를 담음
			req.setAttribute("upmu", upmu);//배열의 주소번지
			//메소드 호출할 때 첫번째 자리에 요청객체를 넘김 ->왜냐면  ActionServlet에서 생성한 String[]을 BoardController에서 재사용 됨
			//request가 저장소의 역할도 가능함
			page = controller.execute(req, resp);
		}
		else if("qna".equals(upmu[0])) {
			controller = new QnaController();
			req.setAttribute("upmu", upmu);
			page = controller.execute(req, resp);
		}
		else if("pay".equals(upmu[0])) {
			controller = new PayController();
			req.setAttribute("upmu", upmu);
			page = controller.execute(req, resp);
		}
		else if("reservation".equals(upmu[0])) {
			controller = new ReservationController();
			req.setAttribute("upmu", upmu);
			page = controller.execute(req, resp);
		}
		else if("comment".equals(upmu[0])) {
			controller = new CommentController();
			req.setAttribute("upmu", upmu);
			page = controller.execute(req, resp);
		}
		//내려 갈 때 전처리 코드
		//올라올 때 후처리 코드 - 출력페이지
		// redirect:board/boardList.jsp or forward:board/boardList.pj2
		if(page !=null) {
			String pageMove[] = null;
			if(page.contains(":")) {
				logger.info("내 안에 콜론있어요");
				pageMove = page.split(":");
			}else {
				logger.info("내 안에 콜론없어요");
				pageMove = page.split("/");
			}//end of if -> 응답문자열을 배열에 담기
			logger.info(pageMove[0]+" , "+pageMove[1]);
			if(pageMove !=null) {//요청에 대해 응답문자열이 있다
				String path = pageMove[1];//pageMove[0]-forward
				if("redirect".equals(pageMove[0])) {
					logger.info("redirect");
					resp.sendRedirect(path);
					//아래 리턴을 반드시 붙여줄것 -  응답이 커밋된 후에는 forward할 수 없음.
					return;
				}
				//forward를 가진거야?
				else if("forward".equals(pageMove[0])) {
					logger.info("forward");
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");//memberList
					view.forward(req, resp);
				}else {
				}
			}//////////////end of 후처리 
		}//page가 null이 아니면
	}//end of doService
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(req, resp);
	}
	
}
