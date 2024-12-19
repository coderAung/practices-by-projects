package org.core.ywa.blog.app.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.core.ywa.blog.app.lib.servlet.Controller;
import org.core.ywa.blog.app.service.CategoryService;
import org.core.ywa.blog.app.service.PostService;
import org.core.ywa.blog.app.service.dto.input.PostForm;
import org.springframework.util.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/posts", "/posts/add", "/posts/edit", "/posts/delete", "/posts/detail"}, loadOnStartup = 1)
public class PostController extends Controller {

	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService;
	private PostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = getBean(PostService.class);
		categoryService = getBean(CategoryService.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/posts/add", "/posts/edit" -> {
			var postId = req.getParameter("id");
			if(StringUtils.hasLength(postId)) {
				postService.findPostDtoById(parseInt(postId)).ifPresent(dto -> req.setAttribute("dto", dto));;
			}
			view("/posts/add", req, resp);
		}
		case "/posts/detail" -> detail(req, resp);
		default -> posts(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/posts/add", "/posts/edit" -> create(req, resp);
		case "/posts/delete" -> delete(req, resp);
		default -> throw new IllegalArgumentException();
		}
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var postId = req.getParameter("id");
		var category = req.getParameter("category");
		
		var form = new PostForm();
		form.setTitle(req.getParameter("title"));
		form.setContent(req.getParameter("content"));
		form.setPostAt(LocalDate.now());
		form.setUserId(1);
		
		if(StringUtils.hasLength(category)) {
			var dto = categoryService.findByName(category).orElseGet(() -> {
				var categoryDto = categoryService.add(category);
				resetCategories();
				return categoryDto;
			});
			form.setCategoryId(dto.getId());
		}
		
		if(StringUtils.hasLength(postId)) {
			form.setId(parseInt(postId));
			var id = postService.update(form);
			redirect("/posts/detail?id=%s".formatted(id), req, resp);
			return;
		}
		
		var id = postService.add(form);
		redirect("/posts/detail?id=%s".formatted(id), req, resp);
	}

	private void resetCategories() {
		getServletContext().setAttribute("categories", categoryService.findAll());
	}

	private void posts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var category = req.getParameter("category");
		if(StringUtils.hasLength(category) && !"All".equalsIgnoreCase(category)) {
			categoryService.findByName(category)
				.ifPresent(dto -> req.setAttribute("list", postService.findByCategory(dto)));
		} else {
			req.setAttribute("list", postService.findAll());
		}
		view("/home", req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var postId = req.getParameter("id");
		if(StringUtils.hasLength(postId)) {
			postService.deleteById(parseInt(postId));
			req.getSession(true).setAttribute("alert", "Post is deleted!");
			redirect("/posts/detail?id=%s".formatted(postId), req, resp);
			return;
		}
	}

	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var postId = req.getParameter("id");
		if(StringUtils.hasLength(postId)) {
			postService.findById(parseInt(postId))
				.ifPresent(dto -> req.setAttribute("post", dto));
		}
		view("/posts/detail", req, resp);
	}
}
