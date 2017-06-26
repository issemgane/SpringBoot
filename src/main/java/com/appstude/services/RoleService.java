package com.appstude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.appstude.entities.Etudiant;
import com.appstude.entities.Role;
import com.appstude.entities.User;
import com.appstude.repositories.RoleRepository;
import com.appstude.repositories.UserRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role add(Role o){
		return roleRepository.save(o);
	}
	
	public List<Role> getAllRoles(){
		List<Role> list = roleRepository.findAll();
		return list;
	}
	
	public Role findOne(String name){
		return roleRepository.findOne(name);
	}
}
