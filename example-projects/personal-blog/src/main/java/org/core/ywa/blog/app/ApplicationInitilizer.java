package org.core.ywa.blog.app;

import org.core.ywa.blog.app.service.CategoryService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationInitilizer implements ServletContextListener {

	private static ConfigurableApplicationContext applicationContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if (null == applicationContext) {
			applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		}
		sce.getServletContext().setAttribute("applicationContext", applicationContext);
		message("Application Start!");

		var service = applicationContext.getBean(CategoryService.class);
		sce.getServletContext().setAttribute("categories", service.findAll());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (null != applicationContext) {
			applicationContext.close();
		}
		message("Application Stop!");
	}

	private void message(String message) {
		System.out.printf("""
				===============================
				%s
				===============================
				""".formatted(message));
	}
}
