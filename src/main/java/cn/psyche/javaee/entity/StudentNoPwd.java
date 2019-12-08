package cn.psyche.javaee.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;

public interface StudentNoPwd {
    int getId();
    String getName();
    String getNickName();
    String getHeadPortrait();
    int getIdentity();
}
