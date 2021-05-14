package com.member.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.member.model.vo.Member;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(urlPatterns= {"/memberView.do","/updateMember"})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
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
		// 로그인 여부를 확인하는 filte 로그인을 했으면 정상적으로 서비스를 실행하고
		//로그인이 안된 상태면 접근 금지시킴
		String userId=request.getParameter("userId");
		HttpSession session=((HttpServletRequest)request).getSession();
		Member m=(Member)session.getAttribute("loginMember");
//		if(session.getAttribute("loginMember")==null) {
			//로그인 하지 않으면...
	if(m==null||!m.getUserId().equals(userId)) {		
		request.setAttribute("msg", "잘못된 접근입니다. 로그인 후 이용할 수 있는 서비스 입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}else {
			
			chain.doFilter(request, response);
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
