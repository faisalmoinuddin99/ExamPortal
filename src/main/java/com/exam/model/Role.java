package com.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String roleName ;


    public Role(String name) {
        this.roleName = name;
    }

    public Role(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return this.roleName;
    }

}
