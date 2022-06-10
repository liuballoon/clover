/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:21
 */
package com.liuballoon.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrdersDO extends BaseDO {
    /**
     * 用户主键
     */
    private String userId;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 商品总价
     */
    private BigDecimal totalPrice;

    /**
     * 实付款
     */
    private BigDecimal payPrice;

    /**
     * 收货地址快照
     */
    private String addressSnapshot;

    /**
     * 描述
     */
    private String description;
}
