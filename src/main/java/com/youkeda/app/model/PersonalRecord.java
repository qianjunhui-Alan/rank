package com.youkeda.app.model;

import java.util.Date;

/**
 * 个人战绩
 *
 * @date 2020/6/5, 周五
 */
public class PersonalRecord {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 积分
     */
    private Integer points;

    /**
     * 场数
     */
    private Integer playNum;

    /**
     * 获胜数
     */
    private Integer winTimes;

    /**
     * 前十数
     */
    private Integer topTenTimes;

    /**
     * 淘汰/被淘汰
     */
    private Double kd;

    /**
     * 淘汰数
     */
    private Integer eliminateNum;

    /**
     * 用户完整信息
     */
    private User user;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 更新时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }

    public Integer getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(Integer winTimes) {
        this.winTimes = winTimes;
    }

    public Integer getTopTenTimes() {
        return topTenTimes;
    }

    public void setTopTenTimes(Integer topTenTimes) {
        this.topTenTimes = topTenTimes;
    }

    public Double getKd() {
        return kd;
    }

    public void setKd(Double kd) {
        this.kd = kd;
    }

    public Integer getEliminateNum() {
        return eliminateNum;
    }

    public void setEliminateNum(Integer eliminateNum) {
        this.eliminateNum = eliminateNum;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
