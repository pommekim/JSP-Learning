

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReDi.do")
public class ReDiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReDiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		if(action.equals("DI")) {
			request.setAttribute("message", "입력하신 이름은 " + name + "입니다."); //구조상 request영역 안에 보내줄 데이터를 저장.
			RequestDispatcher disp = request.getRequestDispatcher("/ReDiResult.jsp"); //1. 디스패쳐 객체 생성 후 경로 지정!
			disp.forward(request, response); //2. 보내줄 객체들 (request, response) 지정!
		} else if(action.equals("RE")) {
			request.setAttribute("message", "입력하신 이름은 " + name + "입니다."); //구조상 request영역 안에 보내줄 데이터를 저장.
			response.sendRedirect("/ReDiResult.jsp");
		}
		
		/*
		 # 꼭 알아야 할 것
		 1. Dispatcher 전송 방식은 request를 통해 받은 데이터를 그대로 디스패쳐 객체에게 위임해
		 그 데이터를 가져다가 가공해 사용자 웹 브라우저에 띄워줄 수 있음.
		 2. 반면에 Redirect 전송 방식은 request가 재요청되어 사용자 웹 브라우저에 띄우므로
		 처음 요청되었던 데이터는 소멸하고 없어지게 되어 사용할 수 없음.
		 3. 간단하게 말해 디스패쳐는 요청된 데이터를 가지고 서블릿에서 가공해 사용자 화면에 띄워줄 때 사용하고,
		 리다이렉트는 단순히 원하는 페이지를 사용자 화면에 띄워줄 때 사용.
		 
		 위와 같은 상황에서 DI방식으로 요청된 데이터는 가공된 결과값을 사용자 화면에 띄울 것이고,
		 RE방식으로 요청된 데이터는 사라지고 없어지게 되어 null값을 사용자 화면에 띄우게 됨!!!
		 */
		
		
		
	}

}
