

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ExamFilter
 */
@WebFilter("/Filter.do")
//이미 존재하는 주소값을 가지게 됨 (자체적으로 자신의 주소를 가지는 경우는 거의 없음)
//한 필터에 여러 주소가 존재할 수 있음!!!
public class ExamFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ExamFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//원래 가던 장소로 보내주는 매개변수 filterchain
		//chain을 기준으로 전처리, 후처리가 나누어지게 됨!!!
		//후처리는 페이지 리사이징 같은 것
		//전처리는 파라미터 인코딩, 로그인 같은 것 (80-90%)
		
		System.out.println("요청 시 필터 실행 중");
		System.out.println(request.getAttribute("message"));
		chain.doFilter(request, response);
		System.out.println("응답 시 필터 실행 중");
		System.out.println(request.getAttribute("message"));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
