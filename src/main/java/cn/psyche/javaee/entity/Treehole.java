package cn.psyche.javaee.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="treehole")
public class Treehole implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    @Basic
    @Column(columnDefinition = "text")
    String content;
    Date sendTime;
    int ownerId;
    int anonymous;

    @Override
    public String toString(){
        return "{ id="+getId()+", title="+getTitle()+", senderId="+getOwnerId()
                +", sendTime="+getSendTime()+", anonymous="+getAnonymous()+"}";
    }

}
