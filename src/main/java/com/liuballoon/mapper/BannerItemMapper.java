/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 13:01
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.BannerItemDO;
import com.liuballoon.vo.BannerItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BannerItemMapper extends BaseMapper<BannerItemDO> {
    /**
     * 根据轮播图id获取所有轮播项
     *
     * @param bannerId 轮播图id
     * @return 轮播项
     */
    List<BannerItemVO> selectItemsByBannerId(@Param("bannerId") String bannerId);
}
