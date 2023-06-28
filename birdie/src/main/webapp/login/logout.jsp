<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();//모든 정보를 삭제//session.removeAttribute("nickname");
	response.sendRedirect("/main.jsp");
//메인페이지 이동 
%>