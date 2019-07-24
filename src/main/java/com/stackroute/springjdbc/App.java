package com.stackroute.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
       ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationBean.class);
       EmployeeDao employeeDao=applicationContext.getBean("employeeDao",EmployeeDao.class);
       Employee employee=new Employee();
       employeeDao.insertData();
       System.out.println(employeeDao.getAllEmployees());
       employeeDao.updateDetails();
       employeeDao.deleteDetails();
    }
}
