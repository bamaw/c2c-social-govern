package com.daobili.social.reward.api;

import java.util.List;

/**
 * 奖励服务接口
 * @author bamaw
 * @date 2021-01-14  23:35
 */
public interface RewardService {


    /**
     * 发放奖励
     * @param reviewerIds 评审员id
     */
    void giveReward(List<Long> reviewerIds);
}
