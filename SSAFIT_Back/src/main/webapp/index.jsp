<%@page import="com.ssafit.video.model.service.VideoServiceImpl"%>
<%@page import="com.ssafit.comment.model.service.CommentServiceImpl"%>
<%@page import="com.ssafit.video.model.repository.VideoRepositoryImpl"%>
<%@page import="com.ssafit.video.model.repository.VideoRepository"%>
<%@page import="com.ssafit.comment.model.repository.CommentRepository"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%!
	//CommentRepositoryImpl commentRepo = CommentRepository.getInstance();
	VideoRepositoryImpl videoRepo = VideoRepositoryImpl.getInstance();
%>
<%
	if(videoRepo.getAllVideos().size()==0){
		//commentRepo.initializeComments();
		videoRepo.initailizeVideos();		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>���� Ž��</h2>
	<form>
		<input type="hidden" name="path" value="video">
		<input type="hidden" name="action" value="sort">
		<select name="sortby">
			<option value="viewCnt">��ȸ�� ����</option>
			<option value="id">�ۼ��� ����</option>
		</select>
		<c:forEach items="${videoRepo.partsList}" var="part">
			<input type="checkbox" name="filter" value="${part}" id="${part}">
			<label for="${part}">${part}</label>
		</c:forEach>
	</form>
	<h2>��ü ����</h2>
	
</body>
</html>