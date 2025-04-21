package com.wenziyue.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenziyue.test.po.UserPO;
import com.wenziyue.test.mapper.UserMapper;
import com.wenziyue.test.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wenziyue
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

}
