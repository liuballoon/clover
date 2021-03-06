package com.liuballoon.common.enums;

/**
 * 订单状态
 */
public enum OrdersStatus {
    CANCELLED(1, "已取消"),
    TO_BE_PAID(2, "待支付"),
    TO_BE_RECEIPT(3, "待收货"),
    COMPLETED(4, "已完成");

    private final int value;
    private final String description;

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    OrdersStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
