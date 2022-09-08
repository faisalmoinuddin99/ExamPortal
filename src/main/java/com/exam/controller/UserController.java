package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService ;

    // create user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        Set<Role> roles = new HashSet<>() ;

        Role role = new Role() ;
        role.setRoleName("USER");

        roles.add(role) ;


        return this.userService.createUser(user, roles) ;
    }

    // get all user details
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getUsers() ;
    }

    // get user by username
    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable("username") String username){
        return userService.getUserByUsername(username) ;
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        return userService.deleteUserById(id) ;
    }

    // update phone no and password
    @PutMapping("/update-phone-password")
    public User updatePhoneAndPassword(@RequestBody User user){
        return userService.updateProduct(user) ;
    }
}
