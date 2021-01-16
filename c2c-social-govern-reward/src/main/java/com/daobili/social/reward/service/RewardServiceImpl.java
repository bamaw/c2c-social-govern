package com.daobili.social.reward.service;

import com.daobili.social.reward.api.RewardService;
import com.daobili.social.reward.dao.RewardCoinDAO;
import com.daobili.social.reward.domain.RewardCoin;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 奖励服务的接口实现类
 * @author bamaw
 * @date 2021-01-03  16:10
 */
@Service(
        version = "1.0.0",
        interfaceClass = RewardService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class RewardServiceImpl implements RewardService{


    /**
     * 奖励金记录DAO组件
     */
    @Autowired
    private RewardCoinDAO rewardCoinDAO;

    /**
     * 发放奖励
     * @param reviewerIds 评审员id
     */
    @Override
    public void giveReward(List<Long> reviewerIds) {

        for (Long reviewerId : reviewerIds) {
            RewardCoin coin = new RewardCoin();
            coin.setReviewerId(reviewerId);
            coin.setCoins(10L);
            rewardCoinDAO.add(coin);
        }

    }
}
