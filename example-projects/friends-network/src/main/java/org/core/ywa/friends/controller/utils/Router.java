package org.core.ywa.friends.controller.utils;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Router {

	public static void redirect(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var url = req.getServletContext().getContextPath().concat("/%s".formatted(path));
		resp.sendRedirect(url);
	}
}
