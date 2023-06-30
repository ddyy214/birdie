<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>birdie 예약</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="../css/reservation.css">
<script>
//주말 또는 주중을 구분
function isWeekendOrHoliday(dateString) {
    var date = new Date(dateString);
    var dayOfWeek = date.getDay();

    // 주말인지 확인 (토요일: 6, 일요일: 0)
    var isWeekend = (dayOfWeek === 6 || dayOfWeek === 0);

    return isWeekend;
}

function calculateTotal() {
    var selectedValue = document.getElementById("Peoplenumber").value;
    var priceWeekday = parseInt(document.getElementById("Peoplenumber").options[document.getElementById("Peoplenumber").selectedIndex].getAttribute("data-price-weekday"));
    var priceWeekend = parseInt(document.getElementById("Peoplenumber").options[document.getElementById("Peoplenumber").selectedIndex].getAttribute("data-price-weekend"));
    var selectedDate = document.getElementById("selectedDate").value; // 선택된 날짜 가져오기
    var isWeekend = isWeekendOrHoliday(selectedDate); // 주말 또는 휴일인지 확인

    var total;
    if (selectedValue === "select" || selectedDate === "") {
        total = "";
    } else {
    	if (isWeekend) {
    	    total = priceWeekend * selectedValue;
    	} else {
    	    total = priceWeekday * selectedValue;
    	}
    }


    // 총합계를 다른 테이블에 표시
    var totalElement = document.getElementById("totalPrice");
    totalElement.textContent = total.toLocaleString() + "원";

    // 총합계를 다른 테이블에 표시하고 hidden 필드에 설정
    var totalPriceInput = document.getElementById("totalPriceInput");
    totalPriceInput.value = total;
}


// 페이지 로드 시 총합계 계산
window.onload = function() {
    calculateTotal();
};
</script>
<style type="text/css">
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
<body onload="calculateTotal()">
	<!-- header start -->
	<%@include file="/include/header.jsp"%>
	<!-- header end   -->
	<div
		style="display: flex; flex-wrap: wrap; justify-content: space-around;">
		<!-- image div 시작 -->
		<div
			style="background-image: url('../image/1번룸.png'); width: 900px; height: 800px; background-position: center; background-repeat: no-repeat;">
		</div>
		<!-- context div 시작 -->
		<div class="context_div">
			<form action="reservationCheck.jsp" method="post" name="select">
				<input type="hidden" name="userId" id="userId"
					value="${successLoginUser}">
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box01">
								<label for="Roomnumber"> <strong>Room 번호</strong>
								</label>
						</td>
						<td style="float: right; padding: 15px;"><select
							name="Roomnumber">
								<option value="select">선택하세요</option>
								<option value="1">1번</option>
								<option value="2">2번</option>
								<option value="3">3번</option>
								<option value="4">4번</option>
								<option value="5">5번</option>
								<option value="6">6번</option>
						</select>
							</div></td>
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
							name="Peoplenumber" id="Peoplenumber" onchange="calculateTotal()">
								<option value="select">선택하세요</option>
								<option value="1" data-price-weekday="20000"
									data-price-weekend="25000">1명</option>
								<option value="2" data-price-weekday="20000"
									data-price-weekend="25000">2명</option>
								<option value="3" data-price-weekday="20000"
									data-price-weekend="25000">3명</option>
								<option value="4" data-price-weekday="20000"
									data-price-weekend="25000">4명</option>
								<option value="5" data-price-weekday="20000"
									data-price-weekend="25000">5명</option>
								<option value="6" data-price-weekday="20000"
									data-price-weekend="25000">6명</option>
						</select>
							</div></td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="float: left; padding: 15px;">
							<div class="box03">
								<label for="time"> <strong>시간 선택</strong>
								</label>
						</td>
						<td style="float: right; padding: 15px;"><select name="time">
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
								<form action="reservationCheck.jsp" method="post">
									<strong>날짜 선택</strong>
								</form>
							</div>
						</td>
						<td style="float: right; padding: 15px;"><input type="date"
							name="selectedDate" id="selectedDate" onchange="calculateTotal()"></td>
					</tr>
				</table>
				<br>
				<table border="1" bordercolor="gray" ; width="400" height="70">
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
							</div>
						</td>
						<td style="float: right; padding: 15px;"><strong
							id="totalPrice">원</strong></td>
					</tr>
				</table>
				<br>
				<table border="1" solid gray; width="400" height="50">
					<tr>
						<td style="text-align: center">
							<!-- totalPrice 값을 hidden 필드에 설정 --> <input type="hidden"
							name="totalPrice" id="totalPriceInput">
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