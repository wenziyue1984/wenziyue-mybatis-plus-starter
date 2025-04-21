package com.wenziyue;


import com.wenziyue.mybatisplus.config.MyBatisPlusConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动配置类，导入分页插件配置
 * @author wenziyue
 */
@Configuration
@Import(MyBatisPlusConfig.class)
public class WenziyueMybatisPlusAutoConfiguration {
}
