package com.youkeda.app.model;

import java.util.Date;

/**
 * 对局信息
 *
 * @date 2020/6/5, 周五
 */
public class MatchData {
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
     * 参赛时间时间（单位：ms）
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

    public Integer getKill() {
        return kill;
    }

    public void setKill(Integer kill) {
        this.kill = kill;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getExistence() {
        return existence;
    }

    public void setExistence(Integer existence) {
        this.existence = existence;
    }

    public Integer getTreatment() {
        return treatment;
    }

    public void setTreatment(Integer treatment) {
        this.treatment = treatment;
    }

    public Integer getRescue() {
        return rescue;
    }

    public void setRescue(Integer rescue) {
        this.rescue = rescue;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Integer getModifiedPoints() {
        return modifiedPoints;
    }

    public void setModifiedPoints(Integer modifiedPoints) {
        this.modifiedPoints = modifiedPoints;
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
