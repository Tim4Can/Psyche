package com.javaee.psyche.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "User")
@Entity
@Data public class User {
    @Id
    @GeneratedValue
    private int id ;

    private String name ;
    private String password;

}
