<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("message") %> <%--request객체에 저장되어 온 message를 얻어오는 메서드 getAttribute --%>
</body>
</html>