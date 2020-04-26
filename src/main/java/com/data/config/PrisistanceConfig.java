package com.data.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class PrisistanceConfig {
	
	  @Autowired
	  private Environment env;
	  
	  /**
	   * 
	   * Data source
	   * 
	   * 
	   */
	  
	  @Bean
	  public DataSource dataSource() {
		  
		 final HikariConfig config=new  HikariConfig();
		 config.setDataSourceClassName(env.getProperty(Constants.Database.DATABASE_DRIVER_DATASOURCE_CLASS));
		 config.addDataSourceProperty("url", env.getProperty(Constants.Database.DATABASE_URL));
		 config.addDataSourceProperty("user", env.getProperty(Constants.Database.DATABASE_USERNAME));
		 config.addDataSourceProperty("password", env.getProperty(Constants.Database.DATABASE_PASSWORD));
		 config.setConnectionTestQuery(env.getProperty(Constants.Database.DATABASE_CONNECTION_TEST_QUERY));
		 config.setMaximumPoolSize(Integer.valueOf(env.getProperty(Constants.Database.DATABASE_MAX_POOL_SIZE)));
		 final HikariDataSource ds=new HikariDataSource(config);
		  		 	  
		return ds;
			  
	  }
	
	  	/**
	  	 * Entity Manager Factory
	  	 * 
	  	 * 
	  	 */
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entitymanagerFactory() {
		  
		 final LocalContainerEntityManagerFactoryBean  entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		 entityManagerFactory.setDataSource(dataSource()); 
		 entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
		 entityManagerFactory.setPackagesToScan("com.data.model","com.data.repositories"); 
		 
		 final HibernateJpaVendorAdapter vendorAdptor = new HibernateJpaVendorAdapter();
		 entityManagerFactory.setJpaVendorAdapter(vendorAdptor); 
		 
		 final Properties addtionalProperties = new Properties();
		 addtionalProperties.put(Constants.Hibernate.HIBERNATE_DIALECT,env.getProperty(Constants.Hibernate.HIBERNATE_DIALECT));
		 addtionalProperties.put(Constants.Hibernate.HIBERNATE_NAMING_STRATEGY,env.getProperty(Constants.Hibernate.HIBERNATE_NAMING_STRATEGY));
		 addtionalProperties.put(Constants.Hibernate.HIBERNATE_SHOW_SQL,env.getProperty(Constants.Hibernate.HIBERNATE_SHOW_SQL));
		 addtionalProperties.put(Constants.Hibernate.HIBERNATE_FORMAT_SQL,env.getProperty(Constants.Hibernate.HIBERNATE_FORMAT_SQL));
		 
		 if(Constants.Strings.TRUE.equals(env.getProperty(Constants.Hibernate.HIBERNATE_SHOULD_VALIDATE))) {
			 
			 addtionalProperties.put(Constants.Hibernate.HIBERNATE_HBM2DDL,env.getProperty(Constants.Hibernate.HIBERNATE_HBM2DDL));
			 
		 }
		 
		 entityManagerFactory.setJpaProperties(addtionalProperties);
		 
		return entityManagerFactory;
			  
	  }
	  
	  
	
	  /**
	   * 
	   * Transction manager
	   * 
	   * 
	   */
	  @Bean
	  public PlatformTransactionManager transactionManager() {
		  
		  final JpaTransactionManager tm= new JpaTransactionManager();
		  tm.setEntityManagerFactory(entitymanagerFactory().getObject());
		  return tm;
	  }
	  
	  /**
	   * Exception transcation
	   * 
	   */
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		  
		  return new PersistenceExceptionTranslationPostProcessor();
	  }
}
