

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormExample.do") //서블릿의 URL주소.
public class FormExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormExampleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 # 꼭 알아야 하는 것.
		 1. http프로토콜을 통해 데이터가 서블릿으로 넘어올 때 요청 객체(request)와 반응 객체(response)가 생성된다는 것을 인지.
		 2. 먼저 request객체가 가지고 온 데이터(파라미터)를 데이터 타입(파라미터는 무조건 문자열로 넘어옴)과 함께 서블릿 클래스 변수에 담아주어야 함.
		 (그래야 서블릿 클래스에서 가공이 가능하기 때문)
		 3. 변수 값에 담긴 데이터(파라미터)를 다시 웹페이지에 띄워줄 수 있도록 html형식으로 셋팅해주고 getWriter메서드를 불러와야 함.
		 */
		
		request.setCharacterEncoding("UTF-8");
		//들어오는 데이터들 중 한글이 제대로 인식되게 하기 위해선 인코딩 방식을 재정의 해줘야 함!!!
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String sdate = request.getParameter("birth");
		SimpleDateFormat tool = new SimpleDateFormat("yyyy-MM-dd");
		//날짜 형식을 원하는데로 지정할 수 있게 해주는 클래스 SimpleDateFormat
		java.util.Date birth = null;
		try {
		    birth = tool.parse(sdate);
		} catch (ParseException e) {}
		//컴파일 exception (겉으론 문법적인 오류가 없어보이지만 예외 발생이 일어날 수 있는 경우 무조건 try catch문으로 작성해야 함.)
		String[] hobbys = request.getParameterValues("hobby");
		//hobby영역은 중복 선택이 가능했기 때문에 여러 데이터를 담을 수 있는 String배열로 받아줌. 그것을 가능하게 하는 메서드 getParameterValues()
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		int grade = Integer.parseInt(request.getParameter("grade"));
		//파라미터는 무조건 문자열로 들어오기 때문에 순수 정수가 들어있는 문자열 타입을 진짜 정수 타입으로 변환하기 위해 Integer.parseInt()메서드를 사용.
		String intro = request.getParameter("intro");
		String area = request.getParameter("area");
		
		
		response.setContentType("text/html;charset=UTF-8");
		//웹페이지에 html형식으로 띄울 수 있도록 셋팅.
		PrintWriter out = response.getWriter();
		//response객체를 통해 getWriter()메서드를 불러 콘솔창이 아닌 웹페이지에 출력할 수 있게 만들어줌.
		out.println("<html>");
		out.println("<head><title>폼 예제 결과</title></head>");
		out.println("<body>");
		
		out.printf("아이디: %s<br>", id);
		out.printf("비밀번호: %s<br>", pw);
		out.printf("생년월일: %s<br>", birth.toString());
		//birth를 그냥 찍으면 객체의 주소값이 튀어나오기 때문에 데이터 값을 그대로 출력할 수 있게 해주는 메서드 toString() 사용.
		out.println("취미: ");
		HashMap<String, String> hobbyMap = new HashMap<>();
		hobbyMap.put("1", "철권");
		hobbyMap.put("2", "위닝");
		hobbyMap.put("3", "오버워치");
		for(String key : hobbys) {
			out.printf("%s ", hobbyMap.get(key));
		}
		//1. 취미영역은 여러 데이터가 들어갈 수 있기 때문에 HashMap컬렉션을 통해 key와 value값을 먼저 맵핑시켜준 후,
		//2. 향상for문을 통해 위에서 받은 hobbys배열을 돌려 key값을 통해 value값을 얻어냄!!!
		out.println("<br>");
		out.printf("성별: %s<br>", gender.equals("F") ? "여" : "남");
		//두가지 중 하나를 선택해서 출력해야 할 때는 간편하게 3항 연산자를 사용.
		out.printf("이메일: %s<br>", email);
		out.printf("연락처: %s<br>", tel);
		out.printf("학년: %d<br>", grade);
		out.printf("자기소개: <pre>%s</pre><br>", intro); //<pre></pre>를 통해 자바의 표현식을 그대로 쓸 수 있음.
		HashMap<String, String> areaMap = new HashMap<>();
		areaMap.put("1", "서울");
		areaMap.put("2", "경기도");
		areaMap.put("3", "경상도");
		areaMap.put("4", "전라도");
		out.printf("지역: %s<br>", areaMap.get(area));
		//area영역에서도 우선 HashMap컬렉션을 통해 key와 value를 맵핑시켜준 후 지정해 둔 key값을 통해 value값을 얻어냄.
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
	}

}
