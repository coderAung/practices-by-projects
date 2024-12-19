package org.core.ywa.blog.app.lib.servlet;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Controller extends SpringSupportServlet {

	private static final long serialVersionUID = 1L;
	
	protected void view(String name, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("%s.jsp".formatted(name)).forward(req, resp);
	}
	
	protected void view(String name, Map<String, Object> params, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var viewName = "%s.jsp";
		if(!params.isEmpty() && 0 < params.size()) {
			viewName = viewName.concat("?");

		}
		getServletContext().getRequestDispatcher(viewName.formatted(name)).forward(req, resp);
	}

	protected void redirect(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(getServletContext().getContextPath().concat(path));
	}
		
	protected int parseInt(String str) {
		return Integer.parseInt(str);
	}
	
}
