<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>"${video.title }" ����</title>
</head>
<body>
<body>
	<div>����: ${video.title }</div>
	<div>����: ${video.description }</div>
	<div>��ȸ��: ${video.viewCount }</div>
	<div>� ����: ${video.category }</div>
	<!-- [�̿ϼ�] MainController�� �̵��ؼ� id�� �´� ��� �����ֱ� -->
	<a href="${pageContext.request.contextPath}/comment/commentList.jsp">��� ����</a>
</body>
</html>