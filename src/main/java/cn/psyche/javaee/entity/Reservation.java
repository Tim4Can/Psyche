package cn.psyche.javaee.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int teacherId;
    int studentId;
    Date date;
    int timePeriod;
    int day;
}
