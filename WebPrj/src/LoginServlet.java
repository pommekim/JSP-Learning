

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디와 패스워드는 한글이 들어가지 않기 때문에 따로 인코딩을 해주진 않았음!
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if("kjy0503".equals(id) && "0000".equals(pw)) {
			HttpSession session = request.getSession(); //세션 객체 생성
			session.setAttribute("id", id); //세션 객체에 id정보를 "id"라는 이름으로 저장 (사용자 식별용)
			//평소처럼 request영역에 담아보내지 않는 이유는 request는 일회성 요청이라 소멸해버리기 때문!!!
			
			Cookie c1 = new Cookie("id", id); //쿠키 객체를 생성해 그 안에 id정보를 저장
			response.addCookie(c1); //response영역에 쿠키를 담아 브라우저에 돌려줌 (request가 아닌 이유는 방식이 이렇기 때문)
			
			response.sendRedirect("/DataIndex.jsp"); //세션이 이미 정보를 들고 있기 때문에 Redirect방식을 사용
		} else {
			request.setAttribute("message", "아이디 또는 비밀번호가 잘못되었습니다."); //request영역에 message저장
			request.getRequestDispatcher("/Login.jsp").forward(request, response); //위 데이터를 들고 가야하기 때문에 Dispatcher사용
		}
	}

}

/*
 # 꼭 알아야 할 것 (세션과 쿠키)
 1. 세션은 서버에서 사용자를 식별하기 위해 저장해두는 객체
 2. 쿠키는 그런 서버에 담긴 정보 중 사용자가 가져야 할 필요한 정보(세션 아이디, 도메인 주소 등)을 담아두는 곳
 3. 세션은 로그인 여부와 상관없이 사용자가 서버에 접속하는 순간 생성됨!
 4. 서버는 세션에 사용자 정보를 담아 저장해두고, response영역에 쿠키를 담아 사용자에게 보내준 후
 다음에 같은 사용자가 서버에 접속했을 때 사용자의 쿠키 정보와 서버의 세션 정보를 비교해 같은 사용자임을 판별할 수 있게 해줌.
 */















