<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/ReDi.do" method="post">
이름: <input type=text name=name><br>
<input type=hidden name=action value=RE> <%--action이라는 숨겨진 데이터 값 RE를 통해 서블릿에서 구분할 수 있게 함. --%>
<input type=submit value=Re>
</form>
<form action="/ReDi.do" method="post">
이름: <input type=text name=name><br>
<input type=hidden name=action value=DI> <%--마찬가지로 action이라는 숨겨진 데이터 값 DI를 통해 서블릿에서 구분할 수 있게 함. --%>
<input type=submit value=Di>
</form>
</body>
</html>