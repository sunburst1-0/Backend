package com.data.config;

public class Constants {
	
	private Constants() {
			
	}
	
	public interface Database{
		
		
		public static final String DATABASE_DRIVER_DATASOURCE_CLASS ="database.driver.datasource.class";
		
		public static final String DATABASE_DRIVER_CLASS ="database.driver.class";
		
		public static final String DATABASE_URL = "database.url";
		
		public static final String DATABASE_USERNAME = "database.username";
		
		public static final String DATABASE_PASSWORD ="database.password";
		
		public static final String DATABASE_CONNECTION_TEST_QUERY = "database.connection.test.query";
		
		public static final String DATABASE_MAX_POOL_SIZE = "database.max.pool.size";
		
	}

		
	public interface Hibernate {
		
		
		public static final String HIBERNATE_DIALECT = "hibernate.dialect";
		
		public static final String HIBERNATE_DIALECT_TEST = "hibernate.dialect_test";
		
		public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
		
		public static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl_auto";
		
		public static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
		
		public static final String HIBERNATE_SHOULD_VALIDATE = "hibernate.should_validate";
		
		public static final String HIBERNATE_NAMING_STRATEGY = "spring.jpa.hibernate.naming-strategy";
		
		public static final String HIBERNATE_INNODB_DIALECT = "spring.jpa.properties.hibernate.dialect";
		
	}
	
	public interface Strings{
		
		public static final String TRUE = "true";
		
		public static final String FALSE = "false";
		
	}
}
