package com.rsp.dao;

//import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.rsp.model.UserBean;

public class UserDAOImpl implements UserDAO {
	
	//JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	JdbcTemplate jdbcTemplate;
	@Override
	public void insert(UserBean user) {
		String query = "insert into user values(?,?,?,?)";
		Object[] objArr = {user.getFirstname(),user.getLastname(),user.getEmail(),user.getPassword()};
		int noOfRowInserted = jdbcTemplate.update(query, objArr);
		System.out.println("No of row inserted is "+noOfRowInserted);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	public DataSource getDataSource(){
//		String url = "jdbc:mysql://localhost:3306/mydb";
//		String username = "root";
//		String password = "root";
//		DataSource dataSource = new DriverManagerDataSource(url,username,password);
//		return dataSource;
//	}

}
