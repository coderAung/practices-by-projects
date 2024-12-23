package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.dto.input.UserSearchForm;
import org.core.ywa.friends.lib.servlet.Controller;
import org.core.ywa.friends.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/users/search"}, loadOnStartup = 1)
public class UserSearchController extends Controller {

	private static final long serialVersionUID = 1L;

	private UserService service;
	
	@Override
	public void init() throws ServletException {
		service = getBean(UserService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var keyword = req.getParameter("keyword");
		var form = new UserSearchForm();
		form.setLoginUser(getLoginUser(req));
		form.setKeyword(keyword);
		var users = service.findByKeyword(form);
		req.setAttribute("users", users);
		view("/users/result", req, resp);
	}
}
