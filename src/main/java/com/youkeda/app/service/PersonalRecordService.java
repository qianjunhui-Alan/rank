package com.youkeda.app.service;

import com.youkeda.app.model.PersonalRecord;

import java.util.List;

/**
 * 个人对局service
 *
 * @date 2020/6/6, 周六
 */
public interface PersonalRecordService {

    /**
     * 添加或者修改个人战绩
     *
     * @param personalRecord 个人战绩
     * @return PersonalRecord
     */
    int save(PersonalRecord personalRecord);

    /**
     * 获取个人战绩
     *
     * @param userId 用户主键
     * @return
     */
    PersonalRecord findByUserId(Long userId);

    List<PersonalRecord> queryLimit(Long limitNum);

    Long getRankIndex(Long userId);

    Integer delete(Long userId);


}
