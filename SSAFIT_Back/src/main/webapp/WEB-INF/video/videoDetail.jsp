<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>"${video.title }" 영상</title>
</head>
<body>
<body>
	<div>제목: ${video.title }</div>
	<div>설명: ${video.description }</div>
	<div>조회수: ${video.viewCount }</div>
	<div>운동 부위: ${video.category }</div>
	<!-- [미완성] MainController로 이동해서 id에 맞는 댓글 보여주기 -->
	<a href="${pageContext.request.contextPath}/comment/commentList.jsp">댓글 보기</a>
</body>
</html>