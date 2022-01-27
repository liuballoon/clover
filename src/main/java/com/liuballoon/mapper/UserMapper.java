/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:26
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    /**
     * 根据条件和查询方式获取用户
     *
     * @param condition 条件
     * @param by 查询方式
     * @return 用户
     */
    UserDO selectUserByCondition(String condition, String by);
}
