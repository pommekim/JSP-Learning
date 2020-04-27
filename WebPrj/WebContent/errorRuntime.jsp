<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%> <%--자바 예외 처리하는 페이지에 꼭 써줘야 exception 내장객체를 생성할 수 있음! --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("<%=exception.getMessage()%>");
history.back();
</script>
</body>
</html>