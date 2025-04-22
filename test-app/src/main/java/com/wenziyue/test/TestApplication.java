package com.wenziyue.test;

import com.wenziyue.mybatisplus.config.MyBatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author wenziyue
 */
@SpringBootApplication
@MapperScan("com.wenziyue.test.mapper")
@Import(MyBatisPlusConfig.class)
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
