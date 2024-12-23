package org.core.ywa.friends.security;

import java.io.IOException;

import org.core.ywa.friends.controller.utils.Router;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/login")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest) request;		
		var session = req.getSession(true);
		var loginUser = session.getAttribute("loginUser");
		if(null != loginUser) {
			var resp = (HttpServletResponse) response;
			Router.redirect("/", req, resp);
			return;
		}
		chain.doFilter(request, response);
	}
}
