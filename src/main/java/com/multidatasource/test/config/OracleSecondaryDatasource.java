package com.multidatasource.test.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(value = "com.multidatasource.test.secondary.repositories",
			entityManagerFactoryRef = "secondaryEntityManagerFactory",
			transactionManagerRef = "secondaryTransactionManager")
public class OracleSecondaryDatasource {

	@Bean
	@ConfigurationProperties("datasource.secondary")
	DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("secondaryEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setDataSource(secondaryDataSource());
	    factory.setPackagesToScan("com.multidatasource.test.secondary.model");
		return factory;
	}

	@Bean("secondaryTransactionManager")
	PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
