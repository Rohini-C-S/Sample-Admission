package com.cts.application.dao;

import java.util.List;


import com.cts.application.entity.User;

public interface UserDao {
    
	boolean createUser(User user);
	List<User> fetchUser();
}
