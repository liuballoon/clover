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
    private String orderNum;
    private BigDecimal totalPrice;
    private BigDecimal payPrice;
    private String addressSnapshot;
    private String description;
}
