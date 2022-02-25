/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/27 11:14
 */
package com.liuballoon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuballoon.common.enums.SelectBy;
import com.liuballoon.model.UserDO;

public interface UserService extends IService<UserDO> {
    /**
     * 根据条件和查询方式获取用户
     *
     * @param condition 条件
     * @param by 查询方式
     * @return 用户
     */
    UserDO getUserByCondition(String condition, SelectBy by);
}
