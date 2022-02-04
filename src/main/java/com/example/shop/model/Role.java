package com.example.shop.model;


import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    @NotEmpty
    private String name;

    @ManyToMany
    private List<User> users;
}
