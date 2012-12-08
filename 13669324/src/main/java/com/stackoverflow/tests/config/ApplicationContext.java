package com.stackoverflow.tests.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Global application context.
 */
@Configuration
@ComponentScan(basePackages = { "com.stackoverflow.tests" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@PropertySource("classpath:application.properties")
@ImportResource("classpath:META-INF/spring/applicationContext.xml")
@Import(DatabaseContext.class)
public class ApplicationContext {

}