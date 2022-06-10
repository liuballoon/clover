/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:35
 */
package com.liuballoon.service;

import com.liuballoon.dto.OrderDTO;

public interface OrdersService {
    /**
     * 下单
     *
     * @param order 订单信息
     */
    void placeOrder(OrderDTO order);
}
