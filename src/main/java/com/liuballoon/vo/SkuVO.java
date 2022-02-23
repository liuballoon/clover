/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/23 16:58
 */
package com.liuballoon.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SkuVO {
    private String id;
    private String spuId;
    private String title;
    private String previewImg;
    private BigDecimal price;
    private Integer stock;
    private String param;
    private String description;
}
