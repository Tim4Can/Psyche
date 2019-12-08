package cn.psyche.javaee.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String headPortrait;
    String introduction;
    String address;
}
