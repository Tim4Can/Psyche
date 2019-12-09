package com.javaee.psyche.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Table(name = "testquestion")
@IdClass(PrimaryKey.class)
@Entity
@Data public class TestQuestion{

    @Id
    private int id;
    @Id
    private int testId;

    private String question;

    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;

    private int nextA;
    private int nextB;
    private int nextC;
    private int nextD;
}
