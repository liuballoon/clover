/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:21
 */
package com.liuballoon.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
     * 商品快照
     */
    private String snapItem;

    /**
     * 收货地址快照
     */
    private String snapAddress;

    /**
     * 过期时间
     */
    private LocalDateTime expiredTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 描述
     */
    private String description;
}
