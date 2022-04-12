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

import java.util.List;

@Mapper
public interface SkuMapper extends BaseMapper<SkuDO> {
    /**
     * 根据商品主键获取所有单品
     *
     * @param SpuId 商品主键
     * @return
     */
    List<SkuVO> selectSkuListBySpuId(String SpuId);
}
