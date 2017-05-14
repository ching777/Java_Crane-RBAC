package com.crane.answer.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.answer.score.dao.ScoreDao;
import com.crane.answer.score.exception.ScoreException;
import com.crane.answer.score.model.Score;
import com.crane.answer.score.service.ScoreService;
import com.crane.commons.model.Pager;
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDao scoreDao;

    @Override
    public List<Score> getPageSelect(Pager pager) {
        return this.scoreDao.getPageSelect(pager);
    }

    @Override
    public List<Score> getClass_name() {
        return this.scoreDao.getClass_name();
    }

    @Override
    public Pager getStudent(Pager pager ) {
        pager.setDatas(getPageSelect(pager));
        return pager;
    }

    @Override
    public Pager getScoreList(Pager pager ) {
        pager.setDatas(this.scoreDao.getScoreList(pager));
        return pager;
    }

    @Override
    public List<Score> getSocreAddClass() {
        return this.scoreDao.getSocreAddClass();
    }

    @Override
    public List<Score> getStudent(String class_name) {
        return this.scoreDao.getStudent(class_name);
    }
    
    @Override
    public void scoreAdd(Score score ) {
        try{
            this.scoreDao.scoreAdd(score);
        }catch(ScoreException e){
            e.printStackTrace();
            throw new ScoreException("ScoreServiceImp类中，scoreAdd方法出错");
        }

    }
    
    @Override
    public Score getScoreInfo(String score_id ) {
        return this.scoreDao.getScoreInfo(score_id);
    }

    @Override
    public void scoreUpdate(Score score ) {
        try{
            this.scoreDao.scoreUpdate(score);
        }catch(ScoreException e){
            e.printStackTrace();
            throw new ScoreException("ScoreServiceImp类中，scoreUpdate方法出错");
        }
    }


}
