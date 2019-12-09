package com.javaee.psyche.dao;

import com.javaee.psyche.entity.TestQuestion;
import com.javaee.psyche.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TestResultDao")
public interface TestResultDao  extends JpaRepository<TestResult,Integer> {
    String findResultAByTestId(int testId);
    String findResultBByTestId(int testId);
    String findResultCByTestId(int testId);
}
