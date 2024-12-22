package org.core.ywa.friends;

import org.core.ywa.friends.service.factory.UserFactory;
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
		initUsers();
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
	
	private void initUsers() {
		var service = applicationContext.getBean(UserFactory.class);
		service.initUsers();
	}
}
