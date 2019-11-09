package com.javaee.psyche.service;

import com.javaee.psyche.dao.TestDao;
import com.javaee.psyche.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("test")
public class TestService {

    @Autowired
    private TestDao testDao;

    public List<Test> getAccounts() {
        return testDao.findAll();
    }


    public Test getAccountById(int id) {
        return testDao.findById(id).orElse(null);
    }


    public String updateAccount(int id, String name,double money) {
        Test test = new Test();
        test.setMoney(money);
        test.setName(name);
        test.setId(id);
        Test test1 = testDao.saveAndFlush(test);

        return test1.toString();

    }


    public void postAccount(String name,double money) {
        Test test = new Test();
        test.setMoney(money);
        test.setName(name);
        testDao.saveAndFlush(test);

    }
}
