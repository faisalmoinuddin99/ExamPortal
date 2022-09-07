package com.exam.service;

import com.exam.model.Role;
import com.exam.model.User;

import java.util.List;
import java.util.Set;


public interface UserService {

    // creating user
    public User createUser(User user, Set<Role> roles) throws Exception;
    public List<User> getUsers() ;

    public User getUserByUsername(String username) ;

    public String deleteUserById(Long id) ;

    public User updateProduct(User user) ;
}
