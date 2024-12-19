package org.core.ywa.blog.app.controller;

import java.io.IOException;

import org.core.ywa.blog.app.lib.servlet.Controller;
import org.core.ywa.blog.app.service.CommentService;
import org.core.ywa.blog.app.service.dto.input.CommentForm;
import org.springframework.util.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/comments", "/comments/delete"}, loadOnStartup = 1)
public class CommentController extends Controller {

	private static final long serialVersionUID = 1L;
	
	private CommentService service;
	
	@Override
	public void init() throws ServletException {
		service = getBean(CommentService.class);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/comments" -> add(req, resp);
		case "/comments/delete" -> delete(req, resp);
		default -> throw new IllegalArgumentException();
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var postId = req.getParameter("postId");
		var commentId = req.getParameter("id");
		if(StringUtils.hasLength(commentId)) {
			service.deleteById(parseInt(commentId));
			redirect("/posts/detail?id=%s".formatted(postId), req, resp);
			return;
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var postId = req.getParameter("postId");
		var comment = req.getParameter("comment");
		if(StringUtils.hasLength(postId) && StringUtils.hasLength(comment)) {
			var form = new CommentForm(parseInt(postId), comment);
			var id = service.add(form);
			redirect("/posts/detail?id=%s".formatted(id), req, resp);
			return;
		}
	}

}
