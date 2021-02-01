package com.youkeda.app.dao;

import com.youkeda.app.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDAO {
    int deleteByPrimaryKey(Long id);

    Long insert(UserDO record);

    int batchInsert(@Param("userDOS") List<UserDO> records);

    UserDO selectByPrimaryKey(Long id);

    List<UserDO> selectAll();

    List<UserDO> queryByIds(@Param("userDOIds") List<Long> ids);

    int updateByPrimaryKey(UserDO record);
}