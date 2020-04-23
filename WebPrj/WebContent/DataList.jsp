<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/DataInput.jsp">입력페이지</a>
<br>
<%HashMap<String, String> map = (HashMap<String, String>) request.getAttribute("map"); %>
<%--request가 가지고 온 map은 object타입이기 때문에 HashMap타입으로 형변환 해주어야 함. --%>
<%--map은 컬렉션이 아니기 때문에 컬렉션으로 바꿔주는 작업(set으로 변환)을 해야 for문을 돌리던가 iterator를 뽑을 수 있음. --%>
<%for(String key : map.keySet()) { %>
이름: <%=key %>, 연락처: <%=map.get(key) %>
<br>
<% } %>

</body>
</html>