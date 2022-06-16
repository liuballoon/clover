/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/16 20:43
 */
package com.liuballoon.service;

import com.liuballoon.dto.SkuDTO;
import com.liuballoon.vo.CartVO;

import java.util.List;

public interface CartService {
    /**
     * 根据用户主键获取购物车
     *
     * @param userId 用户主键
     * @return
     */
    List<CartVO> getCartByUserId(String userId);

    /**
     * 添加商品到购物车
     *
     * @param skuDTO 商品
     */
    void addSkuToCart(SkuDTO skuDTO);

    /**
     * 修改购物车中的商品
     *
     * @param skuDTO 商品
     */
    void updateSkuInCart(SkuDTO skuDTO);

    /**
     * 从购物车中删除商品
     *
     * @param cartId 购物车主键
     */
    void deleteSkuFromCart(String cartId);
}
