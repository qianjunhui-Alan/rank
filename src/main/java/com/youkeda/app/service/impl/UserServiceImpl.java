package com.youkeda.app.service.impl;

import com.youkeda.app.dao.UserDAO;
import com.youkeda.app.dataobject.UserDO;
import com.youkeda.app.model.PersonalRecord;
import com.youkeda.app.model.User;
import com.youkeda.app.service.PersonalRecordService;
import com.youkeda.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/6/6, 周六
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PersonalRecordService personalRecordService;

    @Override
    public Integer save(User user) {

        int success = 0;
        if (user == null) {
            return success;
        }

        UserDO userDO = new UserDO(user);
        if (user.getId() == null) {
            Long insert = userDAO.insert(userDO);

            if (insert == null) {
                return success;
            }

            //创建用户时 默认会创建个人战绩
            PersonalRecord personalRecord = new PersonalRecord();
            personalRecord.setWinTimes(0);
            personalRecord.setTopTenTimes(0);
            personalRecord.setEliminateNum(0);
            personalRecord.setPlayNum(0);
            personalRecord.setPoints(1200);
            personalRecord.setKd(0d);
            personalRecord.setUserId(userDO.getId());

            success = personalRecordService.save(personalRecord);

            //初始化该用户的缓存信息
            redisTemplate.opsForZSet().add("integralRank",userDO.getId(),personalRecord.getPoints());
            //初始化该用户的个人信息用hash存储
            User redisUser=new User();
            redisUser.setAvatar(user.getAvatar());
            redisUser.setNickname(user.getNickname());
            redisTemplate.opsForHash().put("integralRankUser",userDO.getId(),redisUser);
        }else {
            return userDAO.updateByPrimaryKey(userDO);

        }
        return success;
    }

    @Override
    public User get(Long id) {

        if (id == null) {
            return null;
        }

        UserDO userDO = userDAO.selectByPrimaryKey(id);

        if (userDO == null) {
            return null;
        }
        return userDO.convertToModel();
    }

    @Override
    public List<User> queryByIdS(List<Long> userIds) {

        if (CollectionUtils.isEmpty(userIds)) {
            return null;
        }

        List<UserDO> userDAS = userDAO.queryByIds(userIds);

        if (CollectionUtils.isEmpty(userDAS)) {
            return null;
        }

        List<User> users = new ArrayList<>();

        for (UserDO dao : userDAS) {

            User user = dao.convertToModel();
            users.add(user);
        }

        return users;
    }

}
