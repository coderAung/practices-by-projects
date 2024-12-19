package org.core.ywa.blog.app.lib.servlet;

import org.springframework.context.ApplicationContext;

import jakarta.servlet.http.HttpServlet;

public abstract class SpringSupportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected <T> T getBean(Class<T> t) {
		var context = (ApplicationContext) getServletContext().getAttribute("applicationContext");
		var bean = context.getBean(t);
		return bean;
	}
}
