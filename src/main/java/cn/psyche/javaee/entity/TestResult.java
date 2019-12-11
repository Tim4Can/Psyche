package cn.psyche.javaee.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "testresult")
@Entity
@Data public class TestResult{

    @Id
    private int testId;

    private String resultA;
    private String resultB;
    private String resultC;
    private String resultD;

}
