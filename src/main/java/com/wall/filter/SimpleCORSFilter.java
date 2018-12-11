package com.wall.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
		System.out.println("HERE IS THE CORSS ##########@@@@############@@@");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}
}