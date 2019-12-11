package cn.psyche.javaee.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "psytest")
@Entity
@Data public class PsyTest {

    @Id
    @GeneratedValue
    private int Id;
    private String title;
    private String description;

}
