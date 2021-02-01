package com.youkeda.app.dataobject;

import com.youkeda.app.model.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class UserDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户是否有效 0表示无效 1表示有效
     */
    private Integer valid;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 获取主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * 获取创建时间
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * 设置创建时间
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * 获取更新时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置更新时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public UserDO() {

    }

    public UserDO(User user) {

        BeanUtils.copyProperties(user, this);

    }

    public User convertToModel() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}