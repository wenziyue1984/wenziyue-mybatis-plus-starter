package com.wenziyue.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * MyBatis-Plus 分页插件配置
 * @author wenziyue
 */
@Configuration
@ConditionalOnMissingBean({MybatisPlusInterceptor.class, MetaObjectHandler.class})
public class MyBatisPlusConfig {

    private static final String CREATE_TIME = "createTime";

    private static final String UPDATE_TIME = "updateTime";

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 每页最大返回条数为 200 条
        paginationInnerInterceptor.setMaxLimit(200L);
        // 把刚才配置好的分页插件加进总拦截器中。
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        // 乐观锁插件，加入总拦截器中
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 创建时间和修改时间自动填充（+8时区），对应BaseEntity中的createTime和updateTime字段
     * @return MetaObjectHandler
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                LocalDateTime time = LocalDateTime.now(ZoneOffset.of("+8"));
                this.strictInsertFill(metaObject, CREATE_TIME, () -> time, LocalDateTime.class);
                this.strictInsertFill(metaObject, UPDATE_TIME, () -> time, LocalDateTime.class);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.strictUpdateFill(metaObject, UPDATE_TIME, () -> LocalDateTime.now(ZoneOffset.of("+8")), LocalDateTime.class);
            }
        };

    }

}
