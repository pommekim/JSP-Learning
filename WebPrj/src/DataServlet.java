

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Data.do")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	HashMap<String, String> map = new HashMap<>();
	
	
    public DataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("map", map);
		//request에 map이라는 데이터를 "map"이라는 이름으로 저장
		request.getRequestDispatcher("/DataList.jsp").forward(request, response);
		//DataList라는 주소로 request와 response를 넘기겠다!!!
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		map.put(name, tel); //HashMap객체를 만들어 전달받은 name과 tel을 맵핑 시켜줌.
		
		response.sendRedirect("/Data.do"); //자기 자신 서블릿에게 get방식으로 전송.
		
		//알아두기!
		//자기 자신의 서블릿으로 이동할 때 Dispatcher방식을 사용하면 요청이 끊임없이 이어지게 됨.
		//why? Dispatcher방식은 요청이 1회성으로 끊기질 않고 계속 지속되는 상태기 때문.
		//따라서 이 경우엔 꼭 Redirect 전송 방식을 사용해야 함.
		
		
		

	}

}
