/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/5/31 14:53
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SkuDTO {
    private String id;
    private String shopId;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
}
