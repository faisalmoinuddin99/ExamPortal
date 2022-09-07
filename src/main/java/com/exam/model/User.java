package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id ;

    private String username ;

    @Column(nullable = false, length = 64)
    private String password ;
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName ;

   @Column(name = "last_name", nullable = false, length = 20)
    private String lastName ;

    @Column(nullable = false, unique = true, length = 45)
    private String email ;
    private String phone ;
    private String profile ;

    @Column(columnDefinition = "boolean default true")
    private boolean enable  = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


}
