package com.appstude.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.appstude.entities.Role;
import com.appstude.entities.User;
import com.appstude.services.RoleService;
import com.appstude.services.StudentService;
import com.appstude.services.UserService;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class RoleResource {

	@Autowired
	private RoleService roleService;
	
	
	
	@RequestMapping(value ="/roles", method = RequestMethod.POST)
	public Role add(@RequestBody Role o){
		return roleService.add(o);
	}
	
	
   @RequestMapping(value ="/roles", method = RequestMethod.GET)
   public List<Role> getAllRoles(){
	   return roleService.getAllRoles();
    }
   
   @RequestMapping(value ="/roles/{name}", method = RequestMethod.GET)
	public Role get(@PathVariable String name){
		return roleService.findOne(name);
	}
	
}
