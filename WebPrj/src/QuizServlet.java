

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz.do") //서블릿 클래스를 생성하자마자 URL부터 확인.
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuizServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//아이디와 비밀번호가 한글로 작성되는 일은 거의 없기 때문에 이럴 경우엔 굳이 인코딩 방식을 지정해줄 필요가 없음.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String message = null; //출력메세지를 미리 변수에 담아두는 효율적인 방법!!!
		if("kjy0503".equals(id) && "kjy1234".equals(pw)) {
			message = "김지영님 안녕하세요. 환영합니다!";
		} else {
			message = "입력하신 정보가 잘못되었습니다.";
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>퀴즈 결과</title></head>");
		out.println("<body>");
		
		out.println(message);
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
	}

}
