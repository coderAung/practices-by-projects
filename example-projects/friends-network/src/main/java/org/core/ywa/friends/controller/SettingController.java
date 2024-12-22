package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.lib.servlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/settings/logs", "/settings/password"})
public class SettingController extends Controller {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/settings/logs" -> logs(req, resp);
		default -> new IllegalArgumentException();
		}
	}
	
	private void logs(HttpServletRequest req, HttpServletResponse resp) {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/settings/password" -> changePassword(req, resp);
		default -> new IllegalArgumentException();
		}
	}

	private void changePassword(HttpServletRequest req, HttpServletResponse resp) {
	}

}
