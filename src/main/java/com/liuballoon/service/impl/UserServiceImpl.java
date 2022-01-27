/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 11:14
 */
package com.liuballoon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuballoon.core.enums.SelectBy;
import com.liuballoon.mapper.UserMapper;
import com.liuballoon.model.UserDO;
import com.liuballoon.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserDO getUserByCondition(String condition, SelectBy by) {
        return this.baseMapper.selectUserByCondition(condition, by.getValue());
    }
}
