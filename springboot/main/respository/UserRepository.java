package com.springboot.main.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
