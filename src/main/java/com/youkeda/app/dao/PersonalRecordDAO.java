package com.youkeda.app.dao;

import com.youkeda.app.dataobject.PersonalRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonalRecordDAO {

    int deleteByUserId(Long userId);

    int insert(PersonalRecordDO record);

    PersonalRecordDO selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PersonalRecordDO record);

    List<PersonalRecordDO> queryLimit(Long num);

    Long getRankIndex(Long userId);

}