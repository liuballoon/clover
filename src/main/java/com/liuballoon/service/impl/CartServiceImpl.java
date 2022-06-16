/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/16 20:44
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.utils.Serializer;
import com.liuballoon.core.auth.LocalUser;
import com.liuballoon.core.exception.http.NotFoundException;
import com.liuballoon.dto.SkuDTO;
import com.liuballoon.mapper.CartMapper;
import com.liuballoon.mapper.SkuMapper;
import com.liuballoon.model.CartDO;
import com.liuballoon.model.SkuDO;
import com.liuballoon.service.CartService;
import com.liuballoon.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public List<CartVO> getCartByUserId(String userId) {
        return this.cartMapper.selectCartByUserId(userId);
    }

    @Override
    public void addSkuToCart(SkuDTO skuDTO) {
        SkuDO sku = this.skuMapper.selectById(skuDTO.getId());
        if (sku == null) {
            throw new NotFoundException(10504);
        }
        CartDO cart = CartDO.builder()
                .userId(LocalUser.get().getId())
                .shopId(skuDTO.getShopId())
                .skuId(skuDTO.getId())
                .item(Serializer.objectToJson(sku))
                .total(skuDTO.getTotal())
                .build();
        this.cartMapper.insert(cart);
    }

    @Override
    public void updateSkuInCart(SkuDTO skuDTO) {
        // TODO: update sku in cart
    }

    @Override
    public void deleteSkuFromCart(String cartId) {
        this.cartMapper.deleteCartById(cartId);
    }
}
