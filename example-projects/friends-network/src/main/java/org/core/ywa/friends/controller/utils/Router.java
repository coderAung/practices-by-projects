package org.core.ywa.friends.controller.utils;

import java.io.IOException;
import java.util.function.Function;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Router {

	public static void redirect(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var url = req.getServletContext().getContextPath().concat("%s".formatted(path));
		resp.sendRedirect(url);
	}
	
	public static void jsonResponse(HttpServletResponse resp, ResponseFunction<String> func) throws IOException {
		resp.setContentType("application/json");
		var jsonStr = func.doResponse();
		resp.getWriter().append(jsonStr).flush();
	}
	
	public static void jsonResponse(HttpServletRequest req, HttpServletResponse resp, Function<HttpServletRequest, String> func) throws IOException {
		resp.setContentType("application/json");
		var jsonStr = func.apply(req);
		resp.getWriter().append(jsonStr).flush();
	}
}
