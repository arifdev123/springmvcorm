package in.co.javacoder.springmvcorm.user.dao;

import java.util.List;

import in.co.javacoder.springmvcorm.user.entities.User;

public interface UserDao {
	int create(User user);
	List<User> findAllUsers();
	User findUser(Integer id);
}
