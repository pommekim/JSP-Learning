

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
       
	HashMap<String,String> map
	= new HashMap<>();
	
    public DataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//브라우저(크롬)과 서버(톰캣 9.0)은 한글을 지원하기 때문에 이 경우엔 인코딩 지정을 안해줘도 됨!
		String action = request.getParameter("action"); //action이라는 이름의 hidden파라미터를 받아옴.
		String url = ""; //url을 일단 초기화 시켜놓음.
		if(action.equals("list")) {
			request.setAttribute("map", map);
			url = "/DataList.jsp";
		}else if(action.equals("search")) {
			String name = request.getParameter("name"); //받아온 이름값을 변수에 저장.
			request.setAttribute("tel", map.get(name)); //name을 통해 tel정보를 얻어 그것을 request영역에 "tel"로 저장.
			url = "/DataView.jsp"; //받아온 정보를 가지고 DataView.jsp페이지로 이동.
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		map.put(name, tel);
		
		response.sendRedirect("/Data.do?action=list");
		//자기 자신의 서블릿에게 보내므로 Redirect 요청 방식을 사용.
	}

}

















