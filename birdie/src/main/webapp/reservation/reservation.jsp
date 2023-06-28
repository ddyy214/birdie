<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>birdie 예약</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="../css/reservation.css">
<style>
* {
	font-size: 16px;
	font-family: Consolas, sans-serif;
}

table, th {
	border: 1px solid black;
}
.context_div {
  display: flex;
  align-items: center; /* 수직 정렬 */
  flex-direction: row; /* default: row */
  justify-content: center; /* flex direction에 대해서 정렬방식 선택 */
}
</style>
</head>
<body>
	<!-- header start -->
	<%@include file="/include/header.jsp"%>
	<!-- header end   -->
	<div
		style="display: flex; flex-wrap: wrap; justify-content: space-around;">
		<!-- image div 시작 -->
		<div style="background-image: url('../image/1번룸.png'); width: 900px; height: 800px; background-position: center; background-repeat: no-repeat;">
		</div>
		<!-- context div 시작 -->
		<div class="context_div">
			<form action="${contextPath}/reservation/reservationDo" method="post" name="select">
				<input type="hidden" name="userId" id="userId" value="${successLoginUser}">
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box01">
								<label for="Roomnumber"><strong>Room 번호</strong></label>
						</td>
						<td style="float: right; padding: 15px;"><select
							name="number" id="">
								<option value="">선택하세요</option>
								<option value="1">1번</option>
								<option value="2">2번</option>
								<option value="3">3번</option>
								<option value="4">4번</option>
								<option value="5">5번</option>
								<option value="6">6번</option>
						</select>
							</div>
							</td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box02">
								<label for="Peoplenumber"><strong>인원 선택</strong></label>
						</td>
						<td style="float: right; padding: 15px;"><select
							name="number" id="">
								<option value="">선택하세요</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
								<option value="3">3명</option>
								<option value="4">4명</option>
								<option value="5">5명</option>
								<option value="6">6명</option>
						</select>
							</div></td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box03">
								<label for="time"><strong>시간 선택</strong></label>
						</td>
						<td style="float: right; padding: 15px;"><select
							name="number" id="">
								<option value="">선택하세요</option>
								<option value="06-08">06:00-08:00</option>
								<option value="08-10">08:00-10:00</option>
								<option value="10-12">10:00-12:00</option>
								<option value="12-14">12:00-14:00</option>
								<option value="14-16">14:00-16:00</option>
								<option value="16-18">16:00-18:00</option>
								<option value="18-20">18:00-20:00</option>
								<option value="20-22">20:00-22:00</option>
								<option value="22-24">22:00-24:00</option>
						</select>
							</div></td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box04">
								<form>
									<strong>날짜 선택</strong>
						</td>
						<td style="float: right; padding: 15px;"><input type="date">
							</form>
							</div>
						</td>
					</tr>
				</table>
				<br>
				<table border="1" bordercolor="gray"; width="400" height="70">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box05">
								<strong>※ 가격 안내</strong> <br> 주중가격 : 20,000원 <br> 주말가격
								: 25,000원
							</div>
						</td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box06">
								<strong>총 합계 :</strong>
						</td>
						<td style="float: right; padding: 15px;"><strong>원</strong>
							</div></td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="text-align: center">
							<button type="submit" id="next-btn" onclick="insertOpt()">
								<strong>다음단계</strong>
							</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- footer start -->
	<%@include file="/include/bottom.jsp"%>
	<!-- footer end   -->
</body>
</html>