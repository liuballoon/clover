/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 11:14
 */
package com.liuballoon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuballoon.common.enums.SelectBy;
import com.liuballoon.dto.UserInfoDTO;
import com.liuballoon.mapper.UserMapper;
import com.liuballoon.model.UserDO;
import com.liuballoon.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO getUserByCondition(String condition, SelectBy by) {
        return this.baseMapper.selectUserByCondition(condition, by.getValue());
    }

    @Override
    public void updateUserInfo(UserInfoDTO userInfoDTO) {
        UserDO user = new UserDO();
        BeanUtils.copyProperties(userInfoDTO, user);
        this.userMapper.updateById(user);
    }
}
