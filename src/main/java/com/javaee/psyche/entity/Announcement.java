package com.javaee.psyche.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "announcement")
@Entity
@Data
public class Announcement {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String content;
    private Date announcementTime;

}
