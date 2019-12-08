package cn.psyche.javaee.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="comment")
public class Comment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int speakerId;
    int treeHoleId;
    String content;
    Date sendTime;
    int anonymous;
    String speakerName;

    @Override
    public String toString(){
        return "{ id="+getId()+", speakerId="+getSpeakerId()+", treeholeId="+getTreeHoleId()+
                ", content="+getContent()+", sendTime="+getSendTime()+", anonymous="+getAnonymous()+"}";
    }

}
