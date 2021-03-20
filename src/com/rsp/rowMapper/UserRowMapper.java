package com.rsp.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rsp.model.User;

public class UserRowMapper implements RowMapper<User> {
//basically this class map the sql table column to the pojo class fields
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user  = new User();
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
