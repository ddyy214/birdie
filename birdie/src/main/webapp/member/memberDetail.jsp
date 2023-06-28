<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>	
<%
	//html소스와 자바코드를 섞어쓰기할때에 당분간은 맨앞쪽에 위치한다.
	//대체로는 상관이 없다 - 왜냐하면 여기에 적힌 자바코드는 이미 톰캣 서버에서 실행되고
	//결정이 끝난 상태에서 그 결과가 다운로드 되기 때문에 그렇다.
	int size = 0;
    List<Map<String,Object>> mList = (List<Map<String,Object>>)request.getAttribute("mList");
    Map<String, Object> rmap = null;
    if(mList != null) { 
    	size = mList.size();
    	rmap = mList.get(0); //파라미터는 존재한다면 0일것이다-왜냐면 조회가 되더라도 1건일테니까(pk걸어서)
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/member.css">
<script type="text/javascript">
	const memberDelete = () => {
		location.href="./memberCRUD?method=memberDelete&mem_no=<%=rmap.get("mem_no")%>";				
	}
	const memberUpdate = () => {
		//폼 전송을 통해서 사용자가 수정한 정보를 톰캣 서버로 전송하기
		//모달창에 그려진 컴포넌트에 사용자가 입력한 값이 톰캣 서버로 전송되어야한다.
		//그럴려면 submit()함수를 호출해야한다.
		//주의 : 만일 button태그로 버튼을 추가한 경우 따로 submit()함수를 호출하지 않아도 자동 서브밋됨
		//이벤트 버블링 효과가 있어서 이벤트가 하위 컴포넌트에 전이되는것을 막아줘야한다
		//- 버튼을 눌렀는데 화면이 새로고침되거나 깜빡거리면 의심해봐야함 
		document.querySelector("#f_member").submit();
	}
	
</script>
</head>
<body>
	<!-- header start -->
	<%@include file="/include/header.jsp"%>
	<!-- header end    -->
	<!-- body start    -->
	<div class="container">
		<div class="page-header">
			<h2>
				회원관리 <small>회원상세</small>
			</h2>
			<hr />
		</div>
		<!-- 회원목록 시작 -->
		<div style="width: 58rem;">
			<div class="card-body">
				<div class='book-detail'>
					<div class='book-header'>
						<h5 class="card-title"><%=rmap.get("mem_name")%></h5>
						<p class="card-text"><%=rmap.get("mem_id")%></p>
					</div>
				</div>
			</div>
			<div class='detail-link'>
				<button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#memberUpdateForm">
				수정</button>
				&nbsp;
				<button class="btn btn-warning" onclick="memberDelete()">
				삭제</button>
				&nbsp;
				<button class="btn btn-success" onclick="memberList()">
				회원목록</button>
			</div>
		</div>
		<!-- 회원목록   끝  -->
	</div>
	<!-- body end       -->
	<!-- bottom start -->
	<%@include file="/include/bottom.jsp"%>
	<!-- bottom end    -->
	
	    <!-- ========================== [[ 회원정보 수정 Modal ]] ========================== -->
    <div class="modal" id="memberUpdateForm">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
    
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">회원정보 수정</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
    
   		  <!-- 서블릿에서는 doGet메소드 안에서 4가지 경우의 수를 처리해야한다. -->
          <!-- Modal body -->
          <div class="modal-body">
           <form id="f_member" method="get" action="./memberCRUD">
           	  <input type="hidden" name="mem_no" value="<%=rmap.get("mem_no")%>"/>
          	  <input type="hidden" name="method" value="memberUpdate"/>
              <div class="form-floating mb-3 mt-3">
                <input type="text"  class="form-control" id="mem_id" name="mem_id" placeholder="Enter 아이디" value="<%=rmap.get("mem_id")%>"/>
                <label for="mem_id">아이디</label>
              </div>          
              <div class="form-floating mb-3 mt-3">
                <input type="text"  class="form-control" id="mem_pw" name="mem_pw" placeholder="Enter 비밀번호" value="<%=rmap.get("mem_pw")%>"/>
                <label for="mem_pw">비밀번호</label>
              </div>          
              <div class="form-floating mb-3 mt-3">
                <input type="text"  class="form-control" id="mem_name" name="mem_name" placeholder="Enter 이름" value="<%=rmap.get("mem_name")%>"/>
                <label for="mem_name">이름</label>
              </div>          
           </form>
          </div>
    
          <!-- Modal footer -->
          <div class="modal-footer">
            <input type="button" class="btn btn-warning" data-bs-dismiss="modal" onclick="memberUpdate()" value="저장(수정)">
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
          </div>
    
        </div>
      </div>
    </div>
    <!-- ========================== [[ 회원가입 Modal ]] ========================== -->    
	
	
	
	
</body>
</html>