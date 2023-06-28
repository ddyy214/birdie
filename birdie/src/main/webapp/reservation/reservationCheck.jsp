<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Birdie 예약 정보 확인</title>
  <%@include file="/common/bootstrap_common.jsp"%>
  <script type="text/javascript"></script>
<style>
  body {
    padding-left: 200px;
    padding-right: 200px;
  }
  
  hr {
    margin-top: 30px;
    margin-bottom: 30px;
    border: none;
    border-top: 2px solid #000;
  }
  
  .reservation-details {
    font-size: 18px;
    margin-bottom: 30px;
  }
  
  .payment-info {
    font-size: 16px;
    margin-bottom: 30px;
  }
  
  .checkout-button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #4CAF50;
    color: #fff;
    text-decoration: none;
    border-radius: 4px;
    transition: background-color 0.3s ease;
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
  <%@include file="/include/header.jsp"%>
  <hr>
<h2>예약 정보 확인</h2>
<span class="border border-success-subtle"></span>
<div class="reservation-details">
  <p>Room 번호: 1</p>
  <p>날짜: 2023. 06. 27. 18:00-20:00</p>
  <p>인원: 2명</p>
</div>
<hr>
<h2>결제 정보</h2>
<hr>
	<div class="reservation">
  		<input type="radio" name="pay" value="카카오페이(KAKAO PAY)">카카오페이(KAKAO PAY)<br>
  		<input type="radio" name="pay" value="현장 결제">현장 결제<br>
	</div>
<hr>
    <button onclick="reservation()">결제하기</button>
    <br>
    <script>
        function reservation() {
            let jspPath; 
            
            let radioButton = document.querySelector('input[name="pay"]:checked');
            console.log(radioButton);
            if(radioButton != null){
	            if (radioButton.value === "카카오페이(KAKAO PAY)") {
	                jspPath = "/reservation/payment.jsp";
	            } else if (radioButton.value === "현장 결제") {
	                jspPath = "/reservation/reservationConfirmed.jsp";
	            } 
            }else{
	                alert("결제 방법을 고르세요.");
            }
        }
    </script>    
    
  <%@include file="/include/bottom.jsp"%>
</body>
</html>