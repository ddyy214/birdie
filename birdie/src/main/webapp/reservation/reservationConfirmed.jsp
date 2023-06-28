<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Birdie Reservation Success</title>
  <%@include file="/include/header.jsp"%>
  <%@include file="/common/bootstrap_common.jsp"%>
  <link rel="stylesheet" href="/css/notice.css">
  <script type="text/javascript"></script>
  <style>
    body {
      text-align: center;
    }
    
    hr {
      margin-top: 50px;
      margin-bottom: 50px;
      border: none;
      border-top: 2px solid #000;
    }
    
    .success-message {
      text-align: center;
      font-size: 24px;
      margin-bottom: 30px;
    }
    
    .btn-container {
      display: flex;
      justify-content: center;
      margin-bottom: 30px;
    }
    
    .btn {
      display: inline-block;
      padding: 10px 20px;
      background-color: #E1ECC8;
      color: #001C30;
      text-decoration: none;
      border-radius: 4px;
      transition: background-color 0.3s ease;
      margin: 0 10px; 
    }
    
    .btn:hover {
      background-color: #D0F5BE;
    }
  </style>
</head>
<body>
  <hr>
  <div class="success-message">
    <p>예약이 성공적으로 완료되었습니다!</p>
  </div>
  
  <div class="btn-container">
    <a class="btn" href="/myPage/reservationCheck_member.jsp">마이페이지</a>
    <a class="btn" href="/mainPage_mainPage_member">Home</a>
  </div>
  
  <hr>
  <%@include file="/include/bottom.jsp"%>
</body>
</html>