/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 13:38
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.ShopDO;
import com.liuballoon.vo.ShopDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface ShopMapper extends BaseMapper<ShopDO> {
    /**
     * 根据店铺主键获取店铺详情
     *
     * @param shopId 店铺主键
     * @return
     */
    Optional<ShopDetailVO> selectShopDetailById(@Param("shopId") String shopId);
}
