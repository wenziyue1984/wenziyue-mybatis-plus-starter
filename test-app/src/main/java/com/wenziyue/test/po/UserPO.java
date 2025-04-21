package com.wenziyue.test.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wenziyue.mybatisplus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author wenziyue
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserPO extends BaseEntity {

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("age")
    private Integer age;

    @TableField("email")
    private String email;
}
