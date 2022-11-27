package com.youzi.layer.common.config;

import com.youzi.layer.common.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * title SnowflakeIdConfig
 * Description 雪花算法id配置类
 * CreateDate 2022/9/5 16:48
 *
 * @author izhouy
 */
@Configuration
public class SnowflakeIdConfig {

    /**
     * 工作ID (0~31)
     */
    @Value("${snowflake.machine-id:0}")
    private Long machineId;
    /**
     * 数据中心ID (0~31)
     */
    @Value("${snowflake.data-center-id:0}")
    private Long dataCenterId;

    @Bean
    @ConditionalOnMissingBean
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker(machineId, dataCenterId);
    }
}
