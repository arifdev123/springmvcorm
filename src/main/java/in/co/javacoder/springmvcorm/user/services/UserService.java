package in.co.javacoder.springmvcorm.user.services;

import java.util.List;

import in.co.javacoder.springmvcorm.user.entities.User;

public interface UserService {

	int save(User user);

	List<User> getAllUsers();

	User findUser(Integer id);

}
