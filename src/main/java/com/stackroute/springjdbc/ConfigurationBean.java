package com.stackroute.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan(basePackages="com.stackroute.springjdbc")
public class ConfigurationBean {

    @Bean(name="datasource")
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Employee");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");
        return dataSource;
    }
    @Bean(name="employeeDao")
    public EmployeeDao employeeDao()
    {
        return new EmployeeDao();
    }
}
