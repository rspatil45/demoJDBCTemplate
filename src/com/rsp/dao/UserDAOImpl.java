package com.rsp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.rsp.model.User;
import com.rsp.rowMapper.UserRowMapper;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	//JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insert(User user) {
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

	
	@Override
	public void insertBatch(List<User> users) {
		
		String sql = "insert into user values(?,?,?,?)";
		
		//List<Object[]> argArr = new ArrayList<Object[]>();
		
		for(User user : users)
		{
			Object obj[] = {user.getFirstname(),user.getLastname(),user.getEmail(),user.getPassword()};
			jdbcTemplate.update(sql, obj);
			//argArr.add(obj);
		}
		//jdbcTemplate.executeUpdate(sql, argArr);  //not available in spring3.0 may be depricated
		System.out.println("Batch insert successful!");
	}
	
	
	@Override
	public List<User> findAllUsers() {
		String sql = "select * from user";
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}
	
	@Override
	public void cleanUp() {
		String sql = "truncate table user";
		jdbcTemplate.update(sql);
		System.out.println("Table cleaned up ..");
	}
	
	@Override
	public User findByEmail(String email) {
		String query = "select * from user where email = ?";
		User user = jdbcTemplate.queryForObject(query, new UserRowMapper(), email);
		return user;
	}
	
	
	
	
	
//	public DataSource getDataSource(){
//		String url = "jdbc:mysql://localhost:3306/mydb";
//		String username = "root";
//		String password = "root";
//		DataSource dataSource = new DriverManagerDataSource(url,username,password);
//		return dataSource;
//	}
//	NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	
}
