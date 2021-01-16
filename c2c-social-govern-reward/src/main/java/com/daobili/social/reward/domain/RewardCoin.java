package com.daobili.social.reward.domain;

/**
 * 奖励金实体类
 * @author bamaw
 * @date 2021-01-14  23:46
 */
public class RewardCoin {

    /**
     * 奖励金记录id
     */
    private Long id;

    /**
     * 评审员id
     */
    private Long reviewerId;

    /**
     * 奖励金数量
     */
    private Long coins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }
}
