package com.citi.poc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories("com.citi.poc")
@Configuration
public class MobileConfig {
	@Bean
	public DataSource createDataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost/nodedatabase?useSSL=false");
		driverManagerDataSource.setUsername("Rahul");
		driverManagerDataSource.setPassword("Node@pwd");
		return driverManagerDataSource;
	}
	@Bean
	public JpaVendorAdapter createMYSQLJPAVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57InnoDBDialect");
		return adapter;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource , JpaVendorAdapter adapter){
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource);
		entityManager.setJpaVendorAdapter(adapter);
		entityManager.setPackagesToScan("com.citi.poc.model*");
		entityManager.afterPropertiesSet();
		return entityManager;
	}
}
