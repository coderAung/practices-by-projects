package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.lib.servlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/inboxes", "/requests", "/requests/send", "/requests/delete"}, loadOnStartup = 1)
public class FriendRequestController extends Controller {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/inboxes" -> inboxes(req, resp);
		case "/requests" -> requests(req, resp);
		default -> new IllegalArgumentException();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/requests", "/requests/send" -> send(req, resp);
		case "/requests/delete" -> delete(req, resp);
		default -> new IllegalArgumentException();
		}
	}

	private void inboxes(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void requests(HttpServletRequest req, HttpServletResponse resp) {
	}
	
	private void send(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
	}

}
