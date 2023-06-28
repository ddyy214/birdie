<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/main.css?abc">
</head>
<body>
	<!-- header start -->
	<%@include file="/include/header.jsp"%>
	<!-- header end    -->

	<!-- body start    -->
	<div class="container">

<form id="f_login" action="/login/login.pj3" method="post">
			<div class="mb-3 mt-3">
				<label for="mem_id" class="form-label">아이디</label> <input
					type="text" class="form-control" id="mem_id"
					placeholder="Enter id" name="mem_id">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">비밀번호:</label> <input
					type="password" class="form-control" id="mem_pw"
					placeholder="Enter password" name="mem_pw">
			</div>
			<button type="button" id="btn-login" class="btn btn-primary">로그인</button>
			<script>
				const btnLogin = document.querySelector("#btn-login")
				btnLogin.addEventListener('click', (e) => {
					//alert('11');
					document.querySelector("#f_login").submit();
				})
			</script><!-- id는 내껄로, img는 파일에 넣었던거 -->
			<a
				href="https://kauth.kakao.com/oauth/authorize?client_id=fef1d95c7be2e9f63e2b67307d82a222&redirect_uri=http://localhost:9000/auth/kakao/callback&response_type=code"><img
				height="38px" src="/images/kakao_login/ko/kakao_login_medium_narrow.png"></a>
			<button type="button" class="btn btn-success" data-bs-toggle="modal"
				data-bs-target="#memberForm" onclick="location.href='../signup/signUp.jsp'" >회원가입</button>	
		</form>

	</div>
	<!-- body end    -->

	<!-- bottom start -->
	<%@include file="/include/bottom.jsp"%>
	<!-- bottom end    -->
</body>