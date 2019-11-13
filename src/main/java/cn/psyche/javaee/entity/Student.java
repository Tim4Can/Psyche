package cn.psyche.javaee.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="student")
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String nickName;
    private String password;
    private String headPortrait;
    int identity;

    @Override
    public String toString(){
        return "{ id="+getId()+", name="+getName()+", nickName="+getNickName()
                +", headPortrait="+getHeadPortrait()+", identity"+getIdentity()+"}";
    }

    public void copy(Student s){
        this.id=s.id;
        this.name=s.name;
        this.nickName=s.nickName;
        this.headPortrait=s.headPortrait;
        this.identity=s.identity;
    }
}
