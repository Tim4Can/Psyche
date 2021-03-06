package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.PsyTestDao;
import cn.psyche.javaee.dao.TestQuestionDao;
import cn.psyche.javaee.dao.TestResultDao;
import cn.psyche.javaee.entity.PsyTest;
import cn.psyche.javaee.entity.TestQuestion;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PsyTestService")
public class PsyTestService {
    @Autowired
    private PsyTestDao psyTestDao;
    @Autowired
    private TestQuestionDao testQuestionDao;
    @Autowired
    private TestResultDao testResultDao;

    public Result findAlltest(){
        List<PsyTest>testList = psyTestDao.findAll();
        if(testList!=null) {
            return ResultUtil.success(testList);
        }else {
            return ResultUtil.noRecord();
        }
    }

   /* public Result testDetail(int testId){
        TestDetail testDetail = new TestDetail();
        testDetail.setTestId(testId);
        testDetail.setQuestions(testQuestionDao.findAllByTestId(testId));
        testDetail.setTestChoice(testChoiceDao.findTestChoiceByTestId(testId));
        return ResultUtil.success(testDetail);
    }*/

    public Result nextQ(int testId, int qId, int choiceId) {
        int nextId;
        if(choiceId==0){
            TestQuestion testQuestion =testQuestionDao.findTestQuestionByTestIdAndId(testId, 0);
            return  ResultUtil.success(testQuestion);
        }else if (choiceId == 1) {
            nextId = testQuestionDao.findNextAByTestIdAndId(testId, qId);
        }else if(choiceId==2){
            nextId = testQuestionDao.findNextBByTestIdAndId(testId,qId);
        }else{
            nextId = testQuestionDao.findNextCByTestIdAndId(testId, qId);
        }
        if(nextId==0){
            String testResult;
            if (choiceId == 1) {
                testResult = testResultDao.findResultAByTestId(testId);
            }else if(choiceId==2){
                testResult = testResultDao.findResultBByTestId(testId);
            }else{
                testResult = testResultDao.findResultCByTestId(testId);
            }
            return ResultUtil.success(testResult);
        }else {
            TestQuestion testQuestion =testQuestionDao.findTestQuestionByTestIdAndId(testId, nextId);
            return  ResultUtil.success(testQuestion);
        }
    }
}
