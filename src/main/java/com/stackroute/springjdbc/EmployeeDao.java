package com.stackroute.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void insertData()
    {
        String query="insert into employee values(7,'Sruthi',25,'female')";
        jdbcTemplate.execute(query);
        String query1="insert into employee values(8,'Vaishu',19,'female')";
        jdbcTemplate.execute(query1);
    }
    List<Employee> getAllEmployees()

    {
        String query="select * from employee";
        return jdbcTemplate.query(query, new RowMapper<Employee>(){

        @Override
        public Employee mapRow(ResultSet resultSet,int i)throws SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt(1));
            employee.setName(resultSet.getString(2));
            employee.setAge(resultSet.getInt(3));
            employee.setGender(resultSet.getString(4));
            return employee;
        }
});
        }
        public void updateDetails()
        {
            String query="update employee set name='vishnu' where id=3";
            jdbcTemplate.execute(query);
        }

        public void deleteDetails()
        {
            String query="delete from employee where id=2";
            jdbcTemplate.update(query);
        }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public DataSource getDataSource()
    {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
}