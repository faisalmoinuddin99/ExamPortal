package com.exam.service.impl;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.UserFoundException ;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;





    @Override
    public User createUser(User user, Set<Role> roles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());

        if (local != null) {
            System.out.println("User already present");
            throw new UserFoundException() ;
        } else {
            // create user
            for (Role role : roles) {
                roleRepository.save(role);
            }
            user.getRoles().addAll(roles);
            local = this.userRepository.save(user);
        }
        return local;
    }


    // get all user details
    @Override
    public List<User> getUsers() {
        return userRepository.findAll() ;
    }
    // get user by username
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String deleteUserById(Long id) {
        this.userRepository.deleteById(id);

        return "User Deleted Successfully" ;
    }

    @Override
    public User updateProduct(User user) {
      User existingUser = userRepository.findById(user.getId()).orElse(null) ;
      assert existingUser != null ;
      existingUser.setPassword(user.getPassword());
      existingUser.setPhone(user.getPhone());

      return userRepository.save(existingUser) ;
    }
}
