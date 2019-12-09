package com.javaee.psyche.dao;

import com.javaee.psyche.entity.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TestQuestionDao")
public interface TestQuestionDao extends JpaRepository<TestQuestion,Integer> {

    List<TestQuestion>findAllByTestId(int testId);

    TestQuestion findTestQuestionByTestIdAndId(int testId,int Id);

    //@Query("select nextA from TestQuestion where testId =:testId")
    //int findNextQ(@Param("testId") int testId, @Param("choice") int choice);

    int findNextAByTestIdAndId(int testId, int Id);
    int findNextBByTestIdAndId(int testId, int Id);
    int findNextCByTestIdAndId(int testId, int Id);


}
