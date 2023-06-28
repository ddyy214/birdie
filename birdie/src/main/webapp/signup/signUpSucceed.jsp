<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Birdie signUp Success</title>
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
      font-size: 24px;
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
    }
    
    .btn:hover {
      background-color: #D0F5BE;
    }
  </style>
</head>
<body>
  <hr>
  <div class="success-message">
    <p>회원가입이 성공적으로 완료되었습니다</p>
  </div>
  
  <button type="button" class="btn btn-success" data-bs-toggle="modal"
	data-bs-target="#memberForm" onclick="location.href='../login/loginForm.jsp'" >로그인하러가기</button>	
  
  <hr>
</body>
</html>