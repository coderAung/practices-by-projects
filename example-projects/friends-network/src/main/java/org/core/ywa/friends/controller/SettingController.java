package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.controller.utils.Router;
import org.core.ywa.friends.dto.input.PasswordForm;
import org.core.ywa.friends.dto.output.Alert;
import org.core.ywa.friends.dto.output.Alert.AlertType;
import org.core.ywa.friends.lib.servlet.Controller;
import org.core.ywa.friends.service.UserService;
import org.core.ywa.friends.util.exception.ApplicationException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/settings/logs", "/settings/password"})
public class SettingController extends Controller {

	private static final long serialVersionUID = 1L;
	
	private UserService service;
	
	@Override
	public void init() throws ServletException {
		service = getBean(UserService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/settings/logs" -> logs(req, resp);
		case "/settings/password" -> password(req, resp);
		default -> new IllegalArgumentException();
		}
	}
	
	private void password(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Router.jsonResponse(resp, () -> {
			var oldPassword = req.getParameter("oldPassword");
			var loginUser = getLoginUser(req);
			return service.checkPassword(loginUser, oldPassword);
		});
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/settings/password" -> changePassword(req, resp);
		default -> new IllegalArgumentException();
		}
	}

	private void logs(HttpServletRequest req, HttpServletResponse resp) {
	}


	private void changePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var oldPassword = req.getParameter("oldPassword");
		var newPassword = req.getParameter("newPassword");
		var confirmPassword = req.getParameter("confirmPassword");
		
		var form = PasswordForm.builder()
				.loginUserId(getLoginUser(req).getId())
				.oldPassword(oldPassword)
				.newPassword(newPassword)
				.confirmPassword(confirmPassword)
				.build();
		try {
			service.changePassword(form);
			req.getSession(true).setAttribute("alert", new Alert("Password updated successfully!", AlertType.Info));
		} catch (ApplicationException e) {
			req.getSession(true).setAttribute("alert", new Alert(e.getMessage(), AlertType.Danger));
		}
		redirect("/", req, resp);
	}

}
