/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/16 20:54
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.CartDO;
import com.liuballoon.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<CartDO> {
    /**
     * 根据用户主键获取购物车
     *
     * @param userId 用户主键
     * @return
     */
    List<CartVO> selectCartByUserId(@Param("userId") String userId);

    /**
     * 根据购物车主键删除购物车中的商品
     *
     * @param cartId 购物车主键
     */
    void deleteCartById(@Param("cartId") String cartId);
}
