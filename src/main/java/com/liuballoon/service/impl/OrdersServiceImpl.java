/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:35
 */
package com.liuballoon.service.impl;

import com.liuballoon.core.exception.general.OrderException;
import com.liuballoon.dto.OrderDTO;
import com.liuballoon.dto.SkuDTO;
import com.liuballoon.mapper.SkuMapper;
import com.liuballoon.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        this.check(orderDTO);
        this.place(orderDTO);
    }

    /**
     * 校验订单
     *
     * @param orderDTO 订单信息
     */
    private void check(OrderDTO orderDTO) {
        // TODO: 校验工作
    }

    /**
     * 下单
     *
     * @param orderDTO 订单信息
     */
    private void place(OrderDTO orderDTO) {
        this.checkStock(orderDTO.getSkuList());
    }

    /**
     * 校验库存
     *
     * @param skuList 商品列表
     */
    private void checkStock(List<SkuDTO> skuList) {
        skuList.forEach(sku -> this.skuMapper.checkStock(sku.getId(), sku.getTotal()).orElseThrow(() -> new OrderException(10705)));
    }
}
