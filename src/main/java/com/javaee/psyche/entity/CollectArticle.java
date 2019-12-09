package com.javaee.psyche.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "collectArticle")
@Entity
@Data
public class CollectArticle {

    @Id
    @GeneratedValue
    private int id;

    private int collectorId;
    private Date collectTime;
    private int articleId;
}
