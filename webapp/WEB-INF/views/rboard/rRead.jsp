<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

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
			<!-- aside -->
			<c:import url="/WEB-INF/views/includes/aside.jsp"></c:import>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="read">
						<form action="/mysite4/board/" method="get">
							<!-- 작성자 -->
							<div class="form-group">
								<span class="form-text">작성자</span>
								<span class="form-value">${rBoardVo.name}</span>
							</div>
							
							<!-- 조회수 -->
							<div class="form-group">
								<span class="form-text">조회수</span>
								<span class="form-value">${rBoardVo.hit}</span>
							</div>
							
							<!-- 작성일 -->
							<div class="form-group">
								<span class="form-text">작성일</span>
								<span class="form-value">${rBoardVo.regDate}</span>
							</div>
							
							<!-- 제목 -->
							<div class="form-group">
								<span class="form-text">제 목</span>
								<span class="form-value">${rBoardVo.title}</span>
							</div>
						
							<!-- 내용 -->
							<div id="txt-content">
								<span class="form-value" >
									${rBoardVo.content}
								</span>
							</div>
							<input type="text" name="groupNo" value="${rBoardVo.groupNo}">
							<input type="text" name="orderNo" value="${rBoardVo.orderNo}">
							<input type="text" name="depth" value="${rBoardVo.depth}">
							<!-- 그룹/오더/들여쓰기 -->
							
							<c:if test="${authUser != null}">
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/replyForm?no=${rBoardVo.no}">답글</a>
							</c:if>
							<c:if test="${authUser.no == rBoardVo.userNo}">
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/modifyForm?no=${rBoardVo.no}">수정</a>
							</c:if>
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/list">목록</a>
							
						</form>
						<!-- //form -->
					</div>
					<!-- //read -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
