package com.youkeda.app.service.impl;

import com.youkeda.app.dao.PersonalRecordDAO;
import com.youkeda.app.dataobject.PersonalRecordDO;
import com.youkeda.app.model.PersonalRecord;
import com.youkeda.app.model.User;
import com.youkeda.app.service.PersonalRecordService;
import com.youkeda.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @date 2020/6/6, 周六
 */
@Service
public class PersonalRecordServiceImpl implements PersonalRecordService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PersonalRecordDAO personalRecordDAO;

    @Autowired
    private UserService userService;

    @Override
    public int save(PersonalRecord personalRecord) {

        if (personalRecord.getId() == null) {
            return personalRecordDAO.insert(new PersonalRecordDO(personalRecord));
        } else {
            redisTemplate.opsForZSet().add("integralRank",personalRecord.getUserId(),personalRecord.getPoints());
            return personalRecordDAO.updateByPrimaryKey(new PersonalRecordDO(personalRecord));
        }

    }

    @Override
    public PersonalRecord findByUserId(Long userId) {

        if (userId == null) {
            return null;
        }
        Double score = redisTemplate.opsForZSet().score("integralRank", userId);
        User user = (User)redisTemplate.opsForHash().get("integralRankUser", userId);
        if (score != null && user != null){
            PersonalRecord personalRecord = new PersonalRecord();
            personalRecord.setPoints(score.intValue());
            personalRecord.setUser(user);
            personalRecord.setUserId(user.getId());
            return personalRecord;
        }else {
            PersonalRecordDO personalRecordDO = personalRecordDAO.selectByPrimaryKey(userId);
            if (personalRecordDO == null) {
                return null;
            }

            PersonalRecord personalRecord = personalRecordDO.convertToModel();

            //组装战绩和用户信息
            if (personalRecord.getUserId() != null) {
                User user1 = userService.get(personalRecord.getUserId());
                if (user1 != null) {
                    personalRecord.setUser(user);

                }
            }
            return personalRecord;
        }
    }

    @Override
    public List<PersonalRecord> queryLimit(Long limitNum) {
        List<PersonalRecord> lists = new ArrayList<>();
        Set<DefaultTypedTuple> integralRank = redisTemplate.opsForZSet().reverseRangeByScore("integralRank", 0, limitNum - 1);
        if (!CollectionUtils.isEmpty(integralRank)){
            List<Long> userIds = new ArrayList<>();
            for (DefaultTypedTuple redisResult : integralRank){
                PersonalRecord personalRecord = new PersonalRecord();
                personalRecord.setPoints(redisResult.getScore().intValue());
                personalRecord.setUserId((Long) redisResult.getValue());
                lists.add(personalRecord);
                userIds.add((Long) redisResult.getValue());
            }
            List<User> users = redisTemplate.opsForHash().multiGet("integralRankUser", userIds);
            for (PersonalRecord personalRecord : lists){
                for (User user : users){
                    if (personalRecord.getUserId() == user.getId()){
                        personalRecord.setUser(user);
                    }
                }
            }
        }else {
            List<PersonalRecordDO> personalRecordDOS = personalRecordDAO.queryLimit(limitNum);
            personalRecordDOS.forEach(personalRecordDO -> {
                PersonalRecord personalRecord = personalRecordDO.convertToModel();
                User user = userService.get(personalRecord.getUserId());
                personalRecord.setUser(user);
                lists.add(personalRecord);
            });
        }
        return lists;
    }

    @Override
    public Long getRankIndex(Long userId) {
        if (userId == null){
            return null;
        }
        Long integralRank = redisTemplate.opsForZSet().reverseRank("integralRank", userId);
        if (integralRank != null){
            return integralRank + 1;
        }
        Long rankIndex = personalRecordDAO.getRankIndex(userId);
        return rankIndex;
    }

    @Override
    public Integer delete(Long userId) {
        if (userId == null){
            return null;
        }
        return personalRecordDAO.deleteByUserId(userId);
    }

}
