package com.daobili.social.reward.service;

import com.daobili.social.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Service;

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

}
