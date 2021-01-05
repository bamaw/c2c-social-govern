package com.daobili.social.reviewer;

import com.daobili.social.reviewer.config.druid.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author bamaw
 * @date 2021-01-03  15:21
 */
@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class ReviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewerApplication.class, args);
    }
}
