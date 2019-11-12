package com.javaee.psyche.service;

import com.javaee.psyche.dao.UserInfoDao;
import com.javaee.psyche.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfo")
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public User getUserInfoById(int id) {
        return userInfoDao.findById(id).orElse(null);
    }

    public String modifyPassword(int id, String password) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        userInfoDao.saveAndFlush(user);

        return "success...";
    }

}
