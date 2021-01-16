package com.daobili.social.reward.dao;

import com.daobili.social.reward.dao.mapper.RewardCoinMapper;
import com.daobili.social.reward.domain.RewardCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author bamaw
 * @date 2021-01-16  15:49
 */
@Repository
public class RewardCoinDAOImpl implements RewardCoinDAO{


    @Autowired
    private RewardCoinMapper rewardCoinMapper;

    /**
     * 增加奖励金记录
     * @param rewardCoin 奖励金记录实体
     */
    @Override
    public void add(RewardCoin rewardCoin) {
        rewardCoinMapper.insert(rewardCoin);
    }
}
