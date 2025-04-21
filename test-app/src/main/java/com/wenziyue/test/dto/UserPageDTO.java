package com.wenziyue.test.dto;

import com.wenziyue.mybatisplus.page.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wenziyue
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageDTO extends PageRequest {

    private static final long serialVersionUID = 4009990582488251538L;

    private Long id;

    private String name;

    private String email;

}
