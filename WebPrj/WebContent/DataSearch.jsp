<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Data.do"> <%--메서드를 안적었으므로 get방식 --%>
검색하려는 사람의 이름을 입력하세요 : <input type=text name=name><br>
<input type=hidden name=action value=search>
<%--Data서블릿에는 이미 목록조회를 할 수 있는 doGet메서드가 작성되어 있으므로
이를 구분할 수 있는 hidden타입의 파라미터를 하나 생성, value값으로 구분해줌!!!--%>
<input type=submit value=검색>
</form>
<%=session.getId() %>
</body>
</html>