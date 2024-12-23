package org.core.ywa.friends.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.core.ywa.friends.dto.input.FriendForm;
import org.core.ywa.friends.lib.servlet.Controller;
import org.core.ywa.friends.service.FriendService;
import org.springframework.util.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/friends", "/friends/confirm", "/friend/delete"}, loadOnStartup = 1)
public class FriendController extends Controller {

	private static final long serialVersionUID = 1L;
	
	private FriendService service;
	
	@Override
	public void init() throws ServletException {
		service = getBean(FriendService.class);
	}
	
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
		case "/friends/confirm" -> add(req, resp);
		case "/friends/delete" -> delete(req, resp);
		}
	}

	private void friends(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var userId = req.getParameter("id");
		var form = new FriendForm();
		form.setOwnerId(parseInt(userId));
		form.setFriendId(getLoginUser(req).getId());
		form.setCreatedAt(LocalDate.now());
		service.add(form);
		
		var keyword = req.getParameter("keyword");
		if(StringUtils.hasLength(keyword)) {
			redirect("/users/search?keyword=%s".formatted(keyword), req, resp);
			return;
		}
		redirect("/", req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
	}

}
