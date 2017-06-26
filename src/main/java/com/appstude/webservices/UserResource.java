package com.appstude.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appstude.entities.Role;
import com.appstude.entities.User;
import com.appstude.services.RoleService;
import com.appstude.services.StudentService;
import com.appstude.services.UserService;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class UserResource {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	
	@RequestMapping(value ="/users", method = RequestMethod.POST)
	public User add(@RequestBody User o){
		return userService.add(o);
	}
	
	@RequestMapping(value ="/users/{username}", method = RequestMethod.GET)
	public User get(@PathVariable String username){
		return userService.getOne(username);
	}
	
	@RequestMapping(value ="/users", method = RequestMethod.GET)
	public Page<User> getAllStudents(int page,int size){
		return userService.getAllUsers(page, size);
	}
	
	@RequestMapping(value ="/addRoleToUser", method = RequestMethod.POST)
	public User addRoleToUser(String username,String name){
		
		User user = userService.findOne(username);
		Role role = roleService.findOne(name);
		
		user.getRoles().add(role);
		
		user = userService.add(user);
		
		return user;
	}
}
