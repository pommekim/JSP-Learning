<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--# 꼭 알아야 할 것
1. JSP는 서블릿과 동일한 기능을 사용할 수 있기 때문에 문법 또한 똑같이 만들어졌음.
2. 따라서 request객체를 불러와 서블릿과 동일한 방법으로 메서드를 불러주면 됨.
3. 주의할 점은, 조건문이나 반복문을 열고 제대로 닫는 것을 잊지 말아야 함. --%>

<%if(request.getMethod().equals("POST")) { %> <%--요청방식이 무엇인지 String의 형태로 가져다주는 메서드 getMethod() --%>
<%request.setCharacterEncoding("UTF-8"); %> <%--자바코드이기 때문에 컴파일을 해야하므로 세미콜론 붙여줘야 함 --%>
아이디: <%=request.getParameter("id") %><br> <%--출력할 때는 컴파일이 필요없기 때문에 세미콜론 안적어도 됨 --%>
이름: <%=request.getParameter("namd") %>
<% } %> <%--맨 마지막에 if문을 닫아줘야 함 --%>
</body>
</html>