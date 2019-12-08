package cn.psyche.javaee.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="student")
public class Student implements Serializable{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String nickName;
    private String password;
    private String headPortrait;
    int identity;

    @Override
    public String toString(){
        return "{ id="+getId()+", name="+getName()+", nickName="+getNickName()
                +", headPortrait="+getHeadPortrait()+", identity="+getIdentity()+"}";
    }

    public Student copy(){
        Student s=new Student();
        s.id=this.id;
        s.identity=this.identity;
        s.headPortrait=this.headPortrait;
        s.nickName=this.nickName;
        s.name=this.name;

        return s;
    }

}
