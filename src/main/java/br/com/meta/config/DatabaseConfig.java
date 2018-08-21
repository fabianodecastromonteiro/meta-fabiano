package br.com.meta.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.ntidive.repository",
		entityManagerFactoryRef = "entityManagerFactory",
		transactionManagerRef = "transactionManager")
@PropertySource("classpath:persistence-mysql.properties")
public class DatabaseConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.username"));
		dataSource.setPassword(env.getProperty("database.password"));
			
		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"com.ntidive.model"});
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}

	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		if (env.getProperty("hibernate.hbm2ddl.auto") != null) 
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		if (env.getProperty("hibernate.dialect") != null) 
			hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		if (env.getProperty("hibernate.show_sql") != null) 
			hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		if (env.getProperty("hibernate.format_sql") != null) 
			hibernateProperties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		// Initial Data Config
		if (env.getProperty("javax.persistence.schema-generation.database.action") != null) 
			hibernateProperties.setProperty("javax.persistence.schema-generation.database.action", env.getProperty("javax.persistence.schema-generation.database.action"));
		if (env.getProperty("javax.persistence.schema-generation.create-source") != null) 
			hibernateProperties.setProperty("javax.persistence.schema-generation.create-source", env.getProperty("javax.persistence.schema-generation.create-source"));
		if (env.getProperty("javax.persistence.sql-load-script-source") != null) 
			hibernateProperties.setProperty("javax.persistence.sql-load-script-source", env.getProperty("javax.persistence.sql-load-script-source"));
		return hibernateProperties;
	}

}
