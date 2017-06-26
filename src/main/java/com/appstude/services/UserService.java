package com.appstude.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.appstude.entities.Etudiant;
import com.appstude.entities.User;
import com.appstude.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User add(User o){
		return userRepository.save(o);
	}
	
	public User findOne(String username){
		return userRepository.findOne(username);
	}
	
	public Page<User> getAllUsers(int page,int size){
		Page<User> list = userRepository.findAll(new PageRequest(page, size));
		return list;
	}
	
	public User getOne(String username){
		User e = userRepository.getOne(username);
		return e;
	}
}
