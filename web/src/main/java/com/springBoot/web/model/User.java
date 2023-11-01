package com.springBoot.web.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Users")
public class User {
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
