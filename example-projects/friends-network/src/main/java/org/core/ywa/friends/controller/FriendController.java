package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.lib.servlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/friends", "/friends/confirm", "/friend/delete"}, loadOnStartup = 1)
public class FriendController extends Controller {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/friends" -> friends(req, resp);
		default -> new IllegalArgumentException();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/friends/create" -> add(req, resp);
		case "/friends/delete" -> delete(req, resp);
		}
	}

	private void friends(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
	}

}