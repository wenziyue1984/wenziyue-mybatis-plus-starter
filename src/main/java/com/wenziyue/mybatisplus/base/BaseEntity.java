package com.wenziyue.mybatisplus.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wenziyue
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BaseEntity implements Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", update = "now()", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否删除 1表示删除，0表示没有删除
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;
}
