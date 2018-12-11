package com.wall.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wall.entities.User;




public interface UserRepository extends JpaRepository<User, Integer> {
public User findByLogin(String id);
  public User findByLoginAndPassword(String login,String password);
}