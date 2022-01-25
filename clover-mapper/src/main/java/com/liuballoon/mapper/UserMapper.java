/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:26
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.pojo.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    /**
     * 根据openid获取用户主键
     *
     * @param openid 微信openid
     * @return 用户主键
     */
    String selectUserIdByOpenid(String openid);

    /**
     * 根据账号获取用户
     *
     * @param account 账号
     * @return 用户
     */
    Optional<UserDO> selectUserByAccount(String account);
}
