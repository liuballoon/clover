/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:01
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.pojo.model.BannerItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerItemMapper extends BaseMapper<BannerItemDO> {
    /**
     * 根据轮播图id获取所有轮播项
     *
     * @param bannerId 轮播图id
     * @return
     */
    List<BannerItemDO> selectItemsByBannerId(String bannerId);
}
