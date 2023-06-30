<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Birdie 예약 정보 확인</title>
<%@include file="/common/bootstrap_common.jsp"%>
<script type="text/javascript">
  function reservation() {
    const radioButton = document.querySelector('input[name="payment-method"]:checked');
    if (!radioButton) {
      alert("결제 방법을 선택하세요.");
      return false;
    }

    const paymentMethod = radioButton.value;
    let jspPath;

    if (paymentMethod === "kakao-pay") {
      jspPath = "../reservation/payment.jsp";
    } else if (paymentMethod === "on-site-payment") {
      jspPath = "../reservation/reservationConfirmed.jsp";
    }
    
    if (jspPath) {
      window.location.href = jspPath;
    }
  }
  

  function handlePaymentMethodChange() {
    const onSitePaymentRadio = document.getElementById("on-site-payment");
    const checkoutButton = document.getElementById("checkout-button");
    
    if (onSitePaymentRadio.checked) {
      checkoutButton.setAttribute("onclick", "reservation()");
    } else {
      checkoutButton.removeAttribute("onclick");
    }
  }
</script>

<style>
body {
	/*  text-align: left; */
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
	<div>
		<h2>예약 정보 확인</h2>
		<span class="border border-success-subtle"></span>
		<%-- 입력된 정보 가져오기 --%>
		<% String roomNumber = request.getParameter("Roomnumber"); %>
		<% String peopleNumber = request.getParameter("Peoplenumber"); %>
		<% String selectedDate = request.getParameter("selectedDate"); %>
		<% String time = request.getParameter("time"); %>
		<% String totalPriceInput = request.getParameter("totalPrice"); %>


		<div class="reservation-details">
			<p>
				Room 번호 :
				<%= roomNumber %></p>
			<p>
				예약 시간 :
				<%= selectedDate %>,
				<%= time %></p>
			<p>
				인원 :
				<%= peopleNumber %></p>
			<p>
				총 가격 :
				<%= totalPriceInput %>원
			</p>
		</div>
		<hr>
		<h2>결제 정보</h2>
		<hr>
		<div class="payment-info">
			<input type="radio" id="kakao-pay" name="payment-method" value="kakao-pay"> 
				<label for="kakao-pay">카카오페이(KAKAOPAY)</label>
			<br>
			<input type="radio" id="on-site-payment" name="payment-method" value="on-site-payment" onchange="handlePaymentMethodChange()">
				<label for="on-site-payment">현장결제</label>
		</div>
		<hr>
		<a id="checkout-button" class="btn" href="javascript:void(0);" onclick="reservation()">결제하기</a>
	</div>
	<jsp:include page="/include/bottom.jsp" />
</body>
</html>