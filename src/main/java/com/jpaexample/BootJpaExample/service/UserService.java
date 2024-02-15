package com.jpaexample.BootJpaExample.service;

import com.jpaexample.BootJpaExample.dao.UserRepository;
import com.jpaexample.BootJpaExample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser (){
		return (List<User>) userRepository.findAll();
	}
	public User getUserById(int id){
		return userRepository.findById(id).orElse(null);
	}

	public void createUser(User user){
		userRepository.save(user);
	}

	public void deleteUser(int userId){
	User user =	userRepository.findById(userId).orElse(null);
		System.out.println("*** /n Deleted DATA: " + user);
	    userRepository.deleteById(userId);

	}

	public User updateUser(int userId, User updatedUser){
		User user = userRepository.findById(userId).orElse(null);
		System.out.println("*** /n OLD DATA: " + user);

		System.out.println(updatedUser.getName());
		user.setName(updatedUser.getName());
		user.setCity(updatedUser.getCity());
		user.setStatus(updatedUser.getStatus());
		System.out.println("*** /n UPDATED DATA: " + user);
		userRepository.save(user);
		return user;

	}
}
