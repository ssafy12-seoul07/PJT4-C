<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib predix="c" uri="" %>
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
		<c:
		<input type="checkbox" name="filter" value="">
	</form>
</body>
</html>