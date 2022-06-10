/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/24 13:50
 */
package com.liuballoon.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SkuDO extends BaseDO {
    /**
     * 商品主键
     */
    private String spuId;

    /**
     * 名称
     */
    private String name;

    /**
     * 展示图
     */
    private String previewImg;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 折扣价
     */
    private BigDecimal discountPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 描述
     */
    private String description;
}
