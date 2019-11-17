package cn.psyche.javaee.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Data
public class holeList implements Serializable {

    private int id;
    private Date date;
    private String title;

    public holeList(){
        Calendar calendar=Calendar.getInstance();
        id=0;
        date=null;
        title="";
    };
    public holeList(int id, String title, Date date){
        this.id=id;
        this.title=title;
        this.date=date;
    }
    public void setByTreehole(Treehole th){
        id=th.getId();
        date=th.getSendTime();
        title=th.getTitle();
    }
    @Override
    public String toString(){
        return "{ id="+getId()+", title="+getTitle()+", sendTime="+getDate()+"}";
    }
}
