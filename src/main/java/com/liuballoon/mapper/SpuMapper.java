/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 14:10
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.SpuDO;
import com.liuballoon.vo.SpuDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SpuMapper extends BaseMapper<SpuDO> {
    /**
     * 根据商品主键获取商品详情
     *
     * @param spuId 商品主键
     * @return
     */
    Optional<SpuDetailVO> getSpuDetailById(@Param("spuId") String spuId);
}
