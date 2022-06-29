<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootStrap CSS -->
<link
	href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<!-- CSS -->
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">

<!-- js -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<!-- bootstrap -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>
</head>

<body>
	<div id="wrap">

		<!-- header -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header -->

		<!-- nav -->
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li>일반방명록</li>
					<li>ajax방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<%-- 					<form action="${pageContext.request.contextPath}/api/guestbook/add" method="get"> --%>
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label></th>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">패스워드</label></th>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4" class="text-center"><button id="btnSubmit"
										type="submit">등록</button></td>
							</tr>
						</tbody>

					</table>

<!-- 					<button id="btnTest" class="btn btn-primary">모달창</button> -->




					<!-- 리스트 영역 -->
					<p id="listArea"></p>



					<!-- 	
					<c:forEach items="${guestList}" var="guestVo">
					
					<table class="guestRead">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td>${guestVo.no}</td>
							<td>${guestVo.name}</td>
							<td>${guestVo.regDate}</td>
							<td><a href="./deleteForm?no=${guestVo.no}">삭제</a></td>
						</tr>
						<tr>
							<td colspan=4 class="text-left">${guestVo.content}</td>
						</tr>
					</table>
					</c:forEach>
					<!-- //guestRead -->



				</div>
				<!-- //guestbook -->

			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

	<div id="delModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">비밀번호를 입력하세요</h4>
				</div>
				<div class="modal-body"></div>
				
					비밀번호<input type="text" name="password" value="">
					<input type="hidden" name="no" value="">
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary">확인</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



</body>

<script type="text/javascript">
	//준비가 끝났을 때
	$(document).ready(function() {
		//console.log("jquery로 data만 받는 요청");

		fetchList();
	});

	//저장버튼을 클릭했을 때
	$("#btnSubmit").on("click", function() {
		console.log("저장버튼");

		//데이터 수집
		var name = $("[name='name']").val();
		var password = $("[name='password']").val();
		var content = $("[name='content']").val();

		var guestVo = {
			name : name,
			password : password,
			content : content
		}
		console.log(guestVo);

		//저장요청

		$.ajax({

			//url : "${pageContext.request.contextPath }/api/guestbook/add?name=" + name + "&password=" + password + "&content=" + content,		
			url : "${pageContext.request.contextPath }/api/guestbook/add",
			type : "post",
			//contentType : "application/json",
			data : guestVo,

			dataType : "json",
			success : function(gVo) {
				/*성공시 처리해야될 코드 작성*/

				/* 1개데이터 리스트 추가(그리기)하기 */
				render(gVo, "up");

				/* 입력폼 초기화 */
				$("[name='name']").val("");
				$("[name='password']").val("");
				$("[name='content']").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

		//응답을 데이타로 받으려고

	});

	/*
	
	//테스트 버튼을 눌렀을 때
	$("#btnTest").on("click", function() {
		console.log("눌렀냐?");
		$("#delModal").modal("show");
	});
	
	*/
	
	//리스트 삭제
	$("#listArea").on("click", ".btnDel", function(){
		
		var $this = $(this);
		console.log($this);
		
		var no = $this.data("no");
		console.log(no);
		
		
		//모달창에 form no데이타 넣기
		$("[name='password']").val("");
		$("[name='no']").val(no);
		
		//모달창 띄우기
		$("#delModal").modal("show");
		
	});

	//리스트 요청
	function fetchList() {
		$.ajax({

			url : "${pageContext.request.contextPath }/api/guestbook/list",
			type : "post",
			//contentType : "application/json",
			//data : {name: ”홍길동"},

			dataType : "json",
			success : function(guestList) {
				//화면에 data + html을 그린다.
				for (var i = 0; i < guestList.length; i++) {
					render(guestList[i]); //vo --> 화면에 그린다
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}

		});
	};
	
	function delList(){
		$.ajax({
			
			url : "${pageContext.request.contextPath}/api/guestbook/delete",
			type : "post",
			
			data : guestVo,
			dataType : "json"
			
		})
	};
	
	//리스트 그리기 1개씩
	function render(guestVo, opt) {

		console.log("render()");

		var str = "";

		str += '<table class="guestRead">';
		str += "<colgroup>";
		str += '<col style="width: 10%;">';
		str += '<col style="width: 40%;">';
		str += '<col style="width: 40%;">';
		str += '<col style="width: 10%;">';
		str += '</colgroup>';
		str += '<tr>';
		str += '<td>' + guestVo.no + '</td>';
		str += '<td>' + guestVo.name + '</td>';
		str += '<td>' + guestVo.regDate + '</td>';
		str += '<td><button class="btnDel" type="button" data-no="'+ guestVo.no +'">삭제</button></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td colspan=4 class="text-left">' + guestVo.content + '</td>';
		str += '</tr>';
		str += '</table>';

		if (opt == "down") {

			$("#listArea").append(str + "<br>");

		} else if (opt = "up") {
			$("#listArea").prepend(str + "<br>");
		} else {
			console.log("opt오류");
		}

	};
</script>


</html>