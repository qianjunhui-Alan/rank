package com.youkeda.app.service.impl;

import com.youkeda.app.dao.MatchDataDAO;
import com.youkeda.app.dataobject.MatchDataDO;
import com.youkeda.app.model.MatchData;
import com.youkeda.app.model.PersonalRecord;
import com.youkeda.app.service.MatchDataService;
import com.youkeda.app.service.PersonalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date 2020/6/6, 周六
 */
@Service
public class MatchDataServiceImpl implements MatchDataService {

    @Autowired
    private MatchDataDAO matchDataDAO;

    @Autowired
    private PersonalRecordService personalRecordService;

    @Override
    public Integer add(MatchData matchData) {

        if (matchData == null || matchData.getId() != null || matchData.getUserId() == null) {
            return null;
        }

        int success = 0;

        MatchDataDO matchDataDO = new MatchDataDO(matchData);

        //计算这局应该加减的积分，这是模拟的算法
        int points = ((int)((matchData.getKill() - 5) + matchData.getAssists() * 0.5 + matchData.getDamage() * 0.005
                + matchData.getRescue() * 0.5 + (50 - matchData.getRank()) * 0.25));

        matchDataDO.setModifiedPoints(points);

        //查询个人战绩
        PersonalRecord record = personalRecordService.findByUserId(matchDataDO.getUserId());
        //拼装个人战绩
        PersonalRecord personalRecord = getPersonalRecord(record, matchDataDO);

        matchDataDO.setCurrentPoints(record.getPoints() + points);
        matchData.setScore((double)2 * points + 30);

        personalRecordService.save(personalRecord);
        success = matchDataDAO.insert(matchDataDO);

        return success;
    }

    @Override
    public Integer delete(Long userId) {
        if (userId == null){
            return null;
        }
        return matchDataDAO.deleteByUserId(userId);
    }

    private PersonalRecord getPersonalRecord(PersonalRecord personalRecord, MatchDataDO matchDataDO) {

        //第一次玩的玩家需要初始化数据
        if (personalRecord == null) {
            personalRecord = new PersonalRecord();
            personalRecord.setKd(0d);
            personalRecord.setWinTimes(0);
            personalRecord.setTopTenTimes(0);
            personalRecord.setPoints(1200);
            personalRecord.setPlayNum(0);
            personalRecord.setEliminateNum(0);
        }

        //修改个人战绩杀敌数
        personalRecord.setEliminateNum(matchDataDO.getKill() + personalRecord.getEliminateNum());

        //修改个人战绩游戏场数
        personalRecord.setPlayNum(personalRecord.getPlayNum() + 1);

        //修改个人战绩当前总积分
        personalRecord.setPoints(matchDataDO.getCurrentPoints());

        //是否排名第一
        int first = 0;
        if (matchDataDO.getRank() == 1) {
            first = 1;
        }

        //是否是前十
        int topTen = 0;
        if (matchDataDO.getRank() <= 10) {
            topTen = 1;
        }
        personalRecord.setTopTenTimes(personalRecord.getTopTenTimes() + topTen);

        personalRecord.setWinTimes(personalRecord.getWinTimes() + first);

        // 由于如果是第一名不计算死亡数，死亡数等于玩的局数减第一的次数
        int death = personalRecord.getPlayNum() - personalRecord.getWinTimes();
        //如果死亡数为0就默认当一处理ge
        if (death == 0) {
            death = 1;
        }

        // 计算杀敌/死亡
        personalRecord.setKd(personalRecord.getEliminateNum() / (death * 1.0));

        return personalRecord;
    }
}
