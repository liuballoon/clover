/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/20 18:44
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.pojo.model.BannerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BannerMapper extends BaseMapper<BannerDO> {
    /**
     * 根据名称获取轮播图
     *
     * @param name 名称
     * @return
     */
    Optional<BannerDO> selectByName(String name);
}
