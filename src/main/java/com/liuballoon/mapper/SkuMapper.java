/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/12 15:18
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.SkuDO;
import com.liuballoon.vo.SkuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SkuMapper extends BaseMapper<SkuDO> {
    /**
     * 根据商品主键获取所有单品
     *
     * @param spuId 商品主键
     * @return
     */
    List<SkuVO> selectSkuListBySpuId(@Param("spuId") String spuId);

    /**
     * 校验商品库存是否足够
     *
     * @param skuId 商品主键
     * @param buyCount 购买数量
     * @return
     */
    Optional<String> checkStockEnough(@Param("skuId") String skuId, @Param("buyCount") Integer buyCount);
}
