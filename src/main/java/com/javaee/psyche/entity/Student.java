package com.javaee.psyche.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "student")
@Entity
@Data public class Student {

    @Id
    private int Id;

    private String name;
    private String nickName;
    private String password;
    private String headPortrait;
    private int identity;


}
