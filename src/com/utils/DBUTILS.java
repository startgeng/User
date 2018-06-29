package com.utils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUTILS {
private static BasicDataSource dataSource = new BasicDataSource();

static{
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/user");
	dataSource.setUsername("root");
	dataSource.setPassword("123");
	dataSource.setMaxActive(10);
	dataSource.setMaxIdle(5);
	dataSource.setMinIdle(2);
	dataSource.setInitialSize(10);
}
public static DataSource getDataSource(){
	return dataSource;
}
}
