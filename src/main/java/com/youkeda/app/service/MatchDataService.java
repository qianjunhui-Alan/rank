package com.youkeda.app.service;

import com.youkeda.app.model.MatchData;

/**
 * 对局service
 *
 * @date 2020/6/6, 周六
 */
public interface MatchDataService {

    /**
     * 添加对局信息
     *
     * @param matchData 对局
     * @return MatchData
     */
    Integer add(MatchData matchData);

    Integer delete(Long userId);

}
