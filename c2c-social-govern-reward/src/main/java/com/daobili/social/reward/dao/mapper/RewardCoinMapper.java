package com.daobili.social.reward.dao.mapper;

import com.daobili.social.reward.domain.RewardCoin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * 奖励金记录Mapper组件
 * @author bamaw
 * @date 2021-01-14  23:48
 */
@Mapper
public interface RewardCoinMapper {


    /**
     * 插入奖励金记录
     * @param rewardCoin 奖励金记录
     */
    @Insert("INSERT INTO reward_coin(reviewer_id,coins) VALUES(reviewerId,coins) ")
    void insert(RewardCoin rewardCoin);

}
