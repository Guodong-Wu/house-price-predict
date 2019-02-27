package edu.seu.housepricepredict.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guodonwu@163.com
 * @date 10:02 2019/2/27
 * Mybatis配置类
 */

@MapperScan(value = "edu.seu.housepricepredict.mapper")
@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
                configuration.setLazyLoadingEnabled(true);
            }
        };
    }

}
