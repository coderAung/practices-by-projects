package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.lib.servlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends Controller {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var session = req.getSession(true);
		session.removeAttribute("loginUser");
		session.invalidate();
		redirect("/login", req, resp);
	}

}
