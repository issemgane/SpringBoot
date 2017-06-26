package com.appstude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appstude.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
