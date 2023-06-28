<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    // MemberController에서 전달받은 회원가입 결과 처리
    String result = (String) request.getAttribute("result");
    if (result != null) {
        if (result.equals("success")) {
            response.sendRedirect("memberList.jsp");
            return;
        } else if (result.equals("error")) {
            response.sendRedirect("memberError.jsp");
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/member.css">
<script type="text/javascript">
	function hidePassword() {
	    var passwordInput = document.getElementById("password");
	    var hiddenPassword = "";
	
	    for (var i = 0; i < passwordInput.value.length; i++) {
	        hiddenPassword += "*";
	    }
	
	    document.getElementById("hiddenPassword").innerText = hiddenPassword;
	}

	function validateForm() {
	    // 아이디, 비밀번호, 이름, 전화번호, 성별 등 필수 입력 필드를 확인합니다.
	    var id = document.forms["signupForm"]["mem_id"].value;
	    var password = document.forms["signupForm"]["mem_password"].value;
	    var name = document.forms["signupForm"]["mem_name"].value;
	    var phone2 = document.forms["signupForm"]["phone2"].value;
	    var phone3 = document.forms["signupForm"]["phone3"].value;
	    var gender = document.forms["signupForm"]["mem_gender"].value;

	    if (id === "" || password === "" || name === "" || phone2 === "" || phone3 === "" || gender === "") {
	        alert("필수 입력 필드를 모두 작성해주세요.");
	        return false; // 페이지 전환을 막습니다.
	    }

	    return true; // 폼 제출을 허용합니다.
	}
</script>
<style>
.phone-input {
	display: flex;
	align-items: center;
}

.phone-input label {
	display: inline;
	margin-right: 5px;
}

body {
	overflow: auto;
}
</style>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<h1>회원가입</h1>
	<form name="signupForm" action="MemberController" method="post">
		<input type="hidden" name="upmu" value="memberInsert"> 
		<label>아이디:</label>
		<input type="text" name="mem_id" required><br> 
		<label for="password">비밀번호:</label>
   	<input type="password" id="password" name="mem_password" size="43" oninput="hidePassword()"><br> 
		<label>이름:</label>
		<input type="text" name="mem_name" required><br>
<div class="phone-input">
    <label>전화번호:</label>
    <select name="phone1">
        <option>010</option>
        <option>02</option>
        <option>031</option>
        <option>051</option>
    </select>
    <input type="text" name="phone2" size="4" maxlength="4" oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
    -
    <input type="text" name="phone3" size="4" maxlength="4" oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
</div>
		<br> <label>성별:</label> <select name="mem_gender" required>
			<option value="">선택하세요</option>
			<option value="M">남성</option>
			<option value="F">여성</option>
		</select><br>
	<button type="button" class="btn btn-success" data-bs-toggle="modal"
    data-bs-target="#memberForm" onclick="console.log('Button clicked!'); if(validateForm()) location.href='signUpSucceed.jsp';">회원가입</button>
	</form>
	<%@include file="/include/bottom.jsp"%>
	<script type="text/javascript">
    </script>
</body>
</html>