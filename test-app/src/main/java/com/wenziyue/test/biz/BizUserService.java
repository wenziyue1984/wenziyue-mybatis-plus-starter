package com.wenziyue.test.biz;

import com.wenziyue.mybatisplus.page.PageResult;
import com.wenziyue.test.po.UserPO;
import com.wenziyue.test.dto.UserPageDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wenziyue
 */
public interface BizUserService {

    @Transactional(readOnly = true)
    List<UserPO> queryUserList();

    @Transactional(readOnly = true)
    UserPO queryUserById(Long id);

    @Transactional(readOnly = true)
    PageResult<UserPO> pageUser(UserPageDTO dto);
}
