<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("id")!=null) { %>
1. <a href="/DataInput.jsp">정보입력</a>
<br><br>
2. <a href="/Data.do?action=list">목록조회</a>
<br><br>
3. <a href="/DataSearch.jsp">정보검색</a>
<br><br>
4. <a href="/Login.do">로그아웃</a> <%--get방식으로 가기 때문에 doGet메서드에 로그아웃 로직을 작성. --%>
<br><br><br><br>
<%Cookie[] cookies = request.getCookies(); %> <%--cookie는 그 안에 모든 정보를 가져와야 하기 때문에 getCookies()라는 메서드만 존재. --%>
<%for(Cookie c : cookies) { %>
쿠키이름 : <%=c.getName()%>, 쿠키값 : <%=c.getValue()%>, 쿠키지속시간 : <%=c.getMaxAge()%>
<%--쿠키의 여러 값을 얻을 수 있는 메서드들. --%>
<Br>
<% } %>
<% } else {response.sendRedirect("/Login.jsp");} %>
</body>
</html>