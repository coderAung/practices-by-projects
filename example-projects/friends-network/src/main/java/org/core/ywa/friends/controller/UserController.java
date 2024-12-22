package org.core.ywa.friends.controller;

import java.io.IOException;

import org.core.ywa.friends.lib.servlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/users/create", "/users/edit", "/users/delete"}, loadOnStartup = 1)
public class UserController extends Controller {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/users/create" -> view("/users/register", req, resp);
		case "/user/edit" -> view("/users/edit", req, resp);
		default -> view("/index", req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/users", "/users/create" -> create(req, resp);
		case "/user/edit" -> edit(req, resp);
		case "/user/delete" -> delete(req, resp);
		default -> new IllegalArgumentException();
		}
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
	}
}
