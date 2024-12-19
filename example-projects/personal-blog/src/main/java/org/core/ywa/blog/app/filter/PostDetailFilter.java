package org.core.ywa.blog.app.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/posts/detail"})
public class PostDetailFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;
		var postId = req.getParameter("id");
		if(!StringUtils.hasLength(postId)) {
			var resp = (HttpServletResponse) response;
			resp.sendError(400);
			return;
		}
		chain.doFilter(request, response);
	}

}
