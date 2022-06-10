/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:36
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private List<SkuDTO> skuList;
    private BigDecimal totalPrice;
}
