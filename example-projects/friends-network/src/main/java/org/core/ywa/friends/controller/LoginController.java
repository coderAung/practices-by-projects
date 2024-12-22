package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.dto.input.LoginForm;
import org.core.ywa.friends.lib.servlet.Controller;
import org.core.ywa.friends.service.UserService;
import org.core.ywa.friends.util.exception.ApplicationException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends Controller {

	private static final long serialVersionUID = 1L;
	
	private UserService service;
	
	@Override
	public void init() throws ServletException {
		service = getBean(UserService.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(null == req.getSession(true).getAttribute("loginUser")) {
			view("/login", req, resp);
		} else {
			redirect("/", req, resp);
			return;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var form = new LoginForm(req.getParameter("email"), req.getParameter("password"));
		try {
			var loginUser = service.login(form);
			req.getSession(true).setAttribute("loginUser", loginUser);
			redirect("/", req, resp);
		} catch (ApplicationException e) {
			e.printStackTrace();
			req.getSession(true).setAttribute("alert", e.getMessage());
			redirect("/login", req, resp);
		}
	}
}
