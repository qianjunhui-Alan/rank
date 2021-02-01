package com.youkeda.app.dao;

import com.youkeda.app.dataobject.MatchDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MatchDataDAO {
    int insert(MatchDataDO record);

    int deleteByUserId(Long userId);
}