<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String nickname = null;
nickname = (String) session.getAttribute("nickname");
//out.print(nickname);//출력하는 여기는 html땅
%>
<style type="text/css">
/* 전체영역에서 여백을 없애줌 */
	* {
		margin: 0;
		padding: 0;
	}
/* ul li태그에 리스트 스타일과 들여쓰기를 없앰 */
	ul li {
		list-style: none;
		padding-left: 0px;
	}
/* a태그에 텍스트 밑줄을 없애고 색상을 #333 */
	a {
		text-decoration: none;
		color:#333;
	}
/* 글자크기를 16px 맑은 고딕 굵게하고 width넓이 100%, 높이 70만큼 배경색은 #e3dac9, 글자색은 white, 라인높이70px, menu박스 가운데정렬, 글자가운데 정렬 */
	#menu {
		font:bold 16px "malgun gothic";
		width:100%;
		height:70px;
		background: #e3dac9;
		color: white;
		line-height: 70px; 
		margin:0 auto;
		text-align: center;
	}

/* menu태그 자식의 ul의 자식 li를 왼쪽정렬과 넓이 140설정 */
	#menu > ul > li {
		float:left;
		width:140px;
		position:relative;
	}
	#menu > ul > li > ul {
		width:140px;
		display:none;
		position: absolute;
		font-size:14px;
		background: #e3dac9;
	}
	#menu > ul > li:hover > ul {
		display:block;
		padding-left: 0px;
	}
	#menu > ul > li > ul > li:hover {
		background: #edeae0;
		transition: ease 1s;
		}
	#next-btn {
		border: 1px solid white; border-radius: 5px;
		background-color: rgba(0,0,0,0);
		color: black;
		padding: 5px;
		width:80px; height:40px;
	}
	#next-btn:hover {
		color: black;
		padding: 5px;
		background-color: white;
	}
	#next-btn1 {
	border: 1px solid black; border-radius: 5px;
	background-color: rgba(0,0,0,0);
	color: black;
	padding: 5px;
	width:80px; height:40px;
	float: right;
	}
	#next-btn1:hover {
		color: white;
		padding: 5px;
		background-color: gray;
	}
</style>
<body>
	<div id="login">
		<button type="submit" id="next-btn1" onclick="insertOpt()">
			<strong>로그인</strong>
		</button>
	</div>
</body>
<br>
<body>
	<div id="menu">
	<ul>
		<li><a href="#"><h1>Birdie</a></li>
		<li><a href="#">게시판</a>
			<ul>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">Q&A</a></li>
				<li><a href="#">랭킹 게시판</a></li>
			</ul>
		</li>
		<li><a href="#">골프장 소개</a>
			<ul>
				<li><a href="#">오시는길</a></li>
				<li><a href="#">ROOM 정보</a></li>
			</ul>
		</li>
		<li><a href="#">예약</a>
			<ul>
				<li><a href="#">예약하기</a></li>
			</ul>
		</li>
		<li><a href="#">마이페이지</a>
			<ul>
				<li><a href="#">내 정보</a></li>
				<li><a href="#">예약 확인</a></li>
				<li><a href="#">결과 확인</a></li>
			</ul>
		</li>
	</ul>
</div>

</body>
</html>		
			<!--  로그인 성공시 세션에 담긴 이름을 출력하고 로그인 성공한 경우이므로 로그아웃 버튼 추가함  -->
			<%
			if (nickname != null) {
			%>
			<form class="d-flex mb-2 mb-lg-0" role="search">
				<div class="me-auto mt-2 mb-lg-0"><%=nickname%>님.&nbsp;
				</div>
				<!-- 
      	button클릭을 했을 때 onclick은 이벤트 핸들러 이름이다.
      	클릭이 되면 느끼는 것은 브라우저 화면 
      	감지하는 건 js처리를 해야 함 - 이벤트 처리 담당은 자바스크립트 처리함
      	  -->
				<input type="button" onclick="logout()"
					class="btn btn-outline-success" value="로그아웃">
			</form>
			<script type="text/javascript">
      //아래 함수는 로그아웃 버튼이 눌렸을 때 호출됨
      	const logout = () => {
      		console.log('11');//출력이 된다면 호출성공했다는 것임
      		//페이지 이동 -> get방식 -> 주소창이 바뀐다
      		location.href="/login/logoutForm.jsp";//세션에 저장된 nickname을 삭제하기 구현
      	}
      </script>
			<%
			}
			%>
		</div>
	</div>
</nav>