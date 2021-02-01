package com.youkeda.app.dataobject;

import com.youkeda.app.model.MatchData;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class MatchDataDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 玩家
     */
    private Long userId;

    /**
     * 击杀数
     */
    private Integer kill;

    /**
     * 助攻数
     */
    private Integer assists;

    /**
     * 伤害数
     */
    private Integer damage;

    /**
     * 存活时间（单位：ms）
     */
    private Integer existence;

    /**
     * 治疗量
     */
    private Integer treatment;

    /**
     * 救援数
     */
    private Integer rescue;

    /**
     * 评分
     */
    private Double score;

    /**
     * 排名
     */
    private Integer rank;

    /**
     * 当前的积分
     */
    private Integer currentPoints;

    /**
     * 增减的积分
     */
    private Integer modifiedPoints;

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
     * 获取击杀数
     */
    public Integer getKill() {
        return kill;
    }

    /**
     * 设置击杀数
     */
    public void setKill(Integer kill) {
        this.kill = kill;
    }

    /**
     * 获取助攻数
     */
    public Integer getAssists() {
        return assists;
    }

    /**
     * 设置助攻数
     */
    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    /**
     * 获取伤害数
     */
    public Integer getDamage() {
        return damage;
    }

    /**
     * 设置伤害数
     */
    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    /**
     * 获取存活时间（单位：ms）
     */
    public Integer getExistence() {
        return existence;
    }

    /**
     * 设置存活时间（单位：ms）
     */
    public void setExistence(Integer existence) {
        this.existence = existence;
    }

    /**
     * 获取治疗量
     */
    public Integer getTreatment() {
        return treatment;
    }

    /**
     * 设置治疗量
     */
    public void setTreatment(Integer treatment) {
        this.treatment = treatment;
    }

    /**
     * 获取救援数
     */
    public Integer getRescue() {
        return rescue;
    }

    /**
     * 设置救援数
     */
    public void setRescue(Integer rescue) {
        this.rescue = rescue;
    }

    /**
     * 获取评分
     */
    public Double getScore() {
        return score;
    }

    /**
     * 设置评分
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 获取排名
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置排名
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取当前的积分
     */
    public Integer getCurrentPoints() {
        return currentPoints;
    }

    /**
     * 设置当前的积分
     */
    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }

    /**
     * 获取增减的积分
     */
    public Integer getModifiedPoints() {
        return modifiedPoints;
    }

    /**
     * 设置增减的积分
     */
    public void setModifiedPoints(Integer modifiedPoints) {
        this.modifiedPoints = modifiedPoints;
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

    public MatchDataDO() {

    }

    public MatchDataDO(MatchData matchData) {

        BeanUtils.copyProperties(matchData, this);

    }

    public MatchData convertToModel() {
        MatchData matchData = new MatchData();
        BeanUtils.copyProperties(this, matchData);
        return matchData;
    }

}