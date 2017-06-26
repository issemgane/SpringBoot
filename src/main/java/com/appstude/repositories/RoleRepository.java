package com.appstude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appstude.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
