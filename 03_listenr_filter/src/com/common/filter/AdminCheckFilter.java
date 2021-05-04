package com.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AdminCheckFilter
 */
@WebFilter("/admin/*")
public class AdminCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheckFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		String userId=request.getParameter("userId");
		if(userId!=null &&userId.equals("admin")) {
			//userId파라미터가 있고 그 값이 admin이면 요청 서블릿으로 이동
			chain.doFilter(request,response);
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			String html="<html>";
			html+="<body>";
			html+="<h1 style='color:red;'>잘못된 경로로 접근하였습니다.</h1>";
			html+="</body>";
			html+="</html>";
			out.print(html);
			 
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
