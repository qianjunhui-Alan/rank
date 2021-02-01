package com.youkeda.app.service;

import com.youkeda.app.model.User;

import java.util.List;

/**
 * 用户service
 *
 * @date 2020/6/6, 周六
 */
public interface UserService {

    /**
     * 添加或者修改用户
     *
     * @param user 个人战绩
     * @return User
     */
    Integer save(User user);

    /**
     * 获取个人信息
     *
     * @param id 主键
     * @return
     */
    User get(Long id);

    /**
     *
     * @param userIds 用户主键
     * @return List<User>
     */
    List<User> queryByIdS(List<Long> userIds);
}
