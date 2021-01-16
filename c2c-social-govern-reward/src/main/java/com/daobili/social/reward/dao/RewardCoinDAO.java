package com.daobili.social.reward.dao;

import com.daobili.social.reward.domain.RewardCoin;

/**
 * 奖励金记录DAO接口
 * @author bamaw
 * @date 2021-01-16  15:48
 */
public interface RewardCoinDAO {

    /**
     * 增加奖励金记录
     * @param rewardCoin 奖励金记录实体
     */
    void add(RewardCoin rewardCoin);
}
