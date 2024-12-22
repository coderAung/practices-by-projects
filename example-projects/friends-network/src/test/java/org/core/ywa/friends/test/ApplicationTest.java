package org.core.ywa.friends.test;

import org.core.ywa.friends.ApplicationConfiguration;
import org.core.ywa.friends.service.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
public class ApplicationTest {
	
	@Autowired
	private UserFactory factory;

	@Test
	void load() {
		factory.initUsers();
	}
}
