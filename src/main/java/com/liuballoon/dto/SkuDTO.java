/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/5/31 14:53
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
public class SkuDTO {
    @NotBlank(message = "商品不能为空")
    private String id;

    @NotBlank(message = "店铺不能为空")
    private String shopId;

    @Positive(message = "商品总数必须为正整数")
    @Min(value = 1, message = "商品总数不得少于一件")
    private Integer total;
    private BigDecimal price;
    private BigDecimal totalPrice;
}
