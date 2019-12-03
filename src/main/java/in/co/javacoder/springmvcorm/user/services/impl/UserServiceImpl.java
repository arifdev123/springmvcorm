package in.co.javacoder.springmvcorm.user.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.javacoder.springmvcorm.user.dao.UserDao;
import in.co.javacoder.springmvcorm.user.entities.User;
import in.co.javacoder.springmvcorm.user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public int save(User user) {
		return userDao.create(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userDao.findAllUsers();
		Collections.sort(users);
		return users;
	}

	@Override
	public User findUser(Integer id) {
		return userDao.findUser(id);
	}

}
