/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:36
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderDTO {
    private BigDecimal totalPrice;
}
