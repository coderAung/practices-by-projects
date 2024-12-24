package org.core.ywa.friends;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.core.ywa.friends")
@EnableJpaRepositories(basePackages = "org.core.ywa.friends.repo")
public class ApplicationConfiguration {
	
	@Bean
	DataSource dataSource() {
		var bean = new HikariDataSource();
		bean.setJdbcUrl("jdbc:mysql://localhost:3306/friendsDb");
		bean.setUsername("root");
		bean.setPassword("admin");
		bean.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return bean;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("org.core.ywa.friends.entity");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setJpaPropertyMap(Map.of(
				"hibernate.hbm2ddl.auto", "create",
				"hibernate.show_sql", true,
				"hibernate.format_sql", true));
		return bean;
	}
	
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		var bean = new JpaTransactionManager(entityManagerFactory);
		return bean;
	}
	
	@Bean
	ObjectMapper mapper() {
		var bean = new ObjectMapper();
		return bean;
	}

}
