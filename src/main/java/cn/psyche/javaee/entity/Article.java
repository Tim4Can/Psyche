package cn.psyche.javaee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "article")
@Entity
@Data public class Article {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String author;
    private String content;

    private Date issuingTime;

}
