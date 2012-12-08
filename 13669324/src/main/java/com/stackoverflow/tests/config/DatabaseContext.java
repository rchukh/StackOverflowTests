package com.stackoverflow.tests.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DatabaseContext {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_NAME_PERSISTENT_UNIT_NAME = "persistent.unit.name";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
	BoneCPDataSource dataSource = new BoneCPDataSource();
	dataSource.setMaxConnectionsPerPartition(5);
	dataSource.setDriverClass(this.environment
		.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
	dataSource.setJdbcUrl(this.environment
		.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
	dataSource.setUsername(this.environment
		.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
	dataSource.setPassword(this.environment
		.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

	return new LazyConnectionDataSourceProxy(dataSource);
    }

    @Bean
    public JpaTransactionManager transactionManager()
	    throws ClassNotFoundException {
	JpaTransactionManager transactionManager = new JpaTransactionManager();

	transactionManager.setPersistenceUnitName(this.environment
		.getRequiredProperty(PROPERTY_NAME_PERSISTENT_UNIT_NAME));
	transactionManager.setEntityManagerFactory(this
		.entityManagerFactoryBean().getObject());

	return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	    throws ClassNotFoundException {
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

	entityManagerFactoryBean.setPersistenceUnitName(this.environment
		.getRequiredProperty(PROPERTY_NAME_PERSISTENT_UNIT_NAME));
	entityManagerFactoryBean.setDataSource(this.dataSource());
	entityManagerFactoryBean
		.setPackagesToScan(this.environment
			.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
	entityManagerFactoryBean
		.setPersistenceProviderClass(HibernatePersistence.class);

	Properties jpaProterties = new Properties();
	jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, this.environment
		.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
	jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, this.environment
		.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
	jpaProterties
		.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,
			this.environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
	jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, this.environment
		.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

	entityManagerFactoryBean.setJpaProperties(jpaProterties);

	return entityManagerFactoryBean;
    }
}
