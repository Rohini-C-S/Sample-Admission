package com.cts.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.application.dao.UserDao;
import com.cts.application.dao.utility.DBUtility;
import com.cts.application.entity.User;

public class UserDaoImpl implements UserDao{

	
	Connection connection=DBUtility.getConnection();
	
	@Override
	public boolean createUser(User user) {
		
		boolean response=false;
		try {
			PreparedStatement ps =connection.prepareStatement("INSERT INTO User VALUES(?,?,?,?)");
			ps.setInt(1,user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
		   
			int noOfRows=ps.executeUpdate();
			
			if(noOfRows>0) {
				response =true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return response;
		
	}
	

	@Override
	public List<User> fetchUser() {
		List<User> usersList=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM User");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				usersList.add(user);
			}
			return usersList;
		}
		catch(SQLException e) {
			e.printStackTrace();
	}
		return null;
}

}
