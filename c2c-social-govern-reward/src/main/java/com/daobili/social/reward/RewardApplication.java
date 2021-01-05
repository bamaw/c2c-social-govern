package com.daobili.social.reward;

import com.daobili.social.reward.config.druid.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author bamaw
 * @date 2021-01-03  16:06
 */
@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class RewardApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardApplication.class, args);
    }
}
