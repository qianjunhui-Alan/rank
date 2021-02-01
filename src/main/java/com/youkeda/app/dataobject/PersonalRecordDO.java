package com.youkeda.app.dataobject;

import com.youkeda.app.model.PersonalRecord;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PersonalRecordDO {
    /**
     * 主键
     */
    private Long id;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取积分
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 设置积分
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 获取场数
     */
    public Integer getPlayNum() {
        return playNum;
    }

    /**
     * 设置场数
     */
    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }

    /**
     * 获取获胜数
     */
    public Integer getWinTimes() {
        return winTimes;
    }

    /**
     * 设置获胜数
     */
    public void setWinTimes(Integer winTimes) {
        this.winTimes = winTimes;
    }

    /**
     * 获取前十数
     */
    public Integer getTopTenTimes() {
        return topTenTimes;
    }

    /**
     * 设置前十数
     */
    public void setTopTenTimes(Integer topTenTimes) {
        this.topTenTimes = topTenTimes;
    }

    /**
     * 获取淘汰/被淘汰
     */
    public Double getKd() {
        return kd;
    }

    /**
     * 设置淘汰/被淘汰
     */
    public void setKd(Double kd) {
        this.kd = kd;
    }

    /**
     * 获取淘汰数
     */
    public Integer getEliminateNum() {
        return eliminateNum;
    }

    /**
     * 设置淘汰数
     */
    public void setEliminateNum(Integer eliminateNum) {
        this.eliminateNum = eliminateNum;
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

    public PersonalRecordDO() {

    }

    public PersonalRecordDO(PersonalRecord personalRecord) {

        BeanUtils.copyProperties(personalRecord, this);

    }

    public PersonalRecord convertToModel() {
        PersonalRecord personalRecord = new PersonalRecord();
        BeanUtils.copyProperties(this, personalRecord);
        return personalRecord;
    }
}