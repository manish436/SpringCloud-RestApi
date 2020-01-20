package com.hcl.learn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hcl.learn.domain.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {
		return UserDaoService.users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(UserDaoService.users.size() + 1);
		}

		UserDaoService.users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : UserDaoService.users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> usersIterator = users.iterator();
		while (usersIterator.hasNext()) {
			User user = (User) usersIterator.next();
			if (user.getId() == id) {
				usersIterator.remove();
				return user;
			}
		}
		return null;
	}

}
