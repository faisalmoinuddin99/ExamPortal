package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(ExamServerApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting code");
       /*
        User user1 = new User() ;
        user1.setEmail("faisal25march99@gmail.com");
        user1.setUsername("faisal786");
        user1.setFirstName("faisal");
        user1.setLastName("suleman");
        user1.setPhone("8692927930");
        user1.setProfile("dp.png");
        user1.setPassword("faisalfacebook");

        Role role1 = new Role() ;
        role1.setRoleName("ADMIN");

        Role role2 = new Role() ;
        role2.setRoleName("NORMAL");

        Set<Role> roles = new HashSet<>() ;
        roles.add(role1) ;
        roles.add(role2) ;





        User user = this.userService.createUser(user1, roles) ;
        System.out.println(user.getUsername());

        */

    }
}
