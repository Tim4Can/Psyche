package com.javaee.psyche.dao;

import com.javaee.psyche.entity.PsyTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PsyTestDao")
public interface PsyTestDao extends JpaRepository<PsyTest,Integer> {

    List<PsyTest> findAll();



}
