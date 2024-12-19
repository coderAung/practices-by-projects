package org.core.ywa.blog.app.service;

import org.core.ywa.blog.app.ApplicationConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
public class PostServiceTest {

	@Autowired
	private PostService service;

	@Test
	void test_find_all() {
		var list = service.findAll();
		System.out.println(list);
	}
}
