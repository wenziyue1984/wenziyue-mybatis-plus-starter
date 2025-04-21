package com.wenziyue.mybatisplus.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author wenziyue
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_TIME = "createTime";

    private static final String UPDATE_TIME = "updateTime";


    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug(" -------------------- start insert fill ...  --------------------");
        LocalDateTime time = LocalDateTime.now(ZoneOffset.of("+8"));
        this.strictInsertFill(metaObject, CREATE_TIME, () -> time, LocalDateTime.class);
        this.strictInsertFill(metaObject, UPDATE_TIME, () -> time, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug(" -------------------- start update fill ...  --------------------");
        this.strictUpdateFill(metaObject, UPDATE_TIME, () -> LocalDateTime.now(ZoneOffset.of("+8")), LocalDateTime.class);
    }
}
