package com.wenziyue.test.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenziyue.mybatisplus.page.PageResult;
import com.wenziyue.test.po.UserPO;
import com.wenziyue.test.dto.UserPageDTO;
import com.wenziyue.test.biz.BizUserService;
import com.wenziyue.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenziyue
 */
@Service
@Slf4j
public class BizUserServiceImpl implements BizUserService {

    @Autowired
    private UserService userService;

    @Override
    public List<UserPO> queryUserList() {
        return userService.list();
    }

    @Override
    public UserPO queryUserById(Long id) {
        val po = userService.getById(id);
        if (po == null) {
            throw new RuntimeException("无此用户");
        }
        return po;
    }

    @Override
    public PageResult<UserPO> pageUser(UserPageDTO dto) {
        return userService.page(dto, Wrappers.<UserPO>lambdaQuery()
                .eq(dto.getId() != null, UserPO::getId, dto.getId())
                .like(dto.getName() != null, UserPO::getName, dto.getName())
                .like(dto.getEmail() != null, UserPO::getEmail, dto.getEmail())
                .orderByDesc(UserPO::getUpdateTime));
    }
}
