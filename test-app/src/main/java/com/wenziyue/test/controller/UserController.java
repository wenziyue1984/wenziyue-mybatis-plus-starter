package com.wenziyue.test.controller;

import com.wenziyue.mybatisplus.page.PageResult;
import com.wenziyue.test.dto.UserPageDTO;
import com.wenziyue.test.biz.BizUserService;
import com.wenziyue.test.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenziyue
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private BizUserService bizUserService;

    @GetMapping("/{id}")
    public UserPO testUser(@PathVariable("id") Long id) {
        return bizUserService.queryUserById(id);
    }

    @GetMapping("/page")
    public PageResult<UserPO> listProducts(UserPageDTO dto) {
        log.info("dto:{}", dto);
        return bizUserService.pageUser(dto);
    }
}
