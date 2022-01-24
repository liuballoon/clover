/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/24 13:50
 */
package com.liuballoon.pojo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SkuDO extends BaseDO {
    private String spuId;
    private String title;
    private String previewImg;
    private BigDecimal price;
    private Integer stock;
    private String param;
    private Boolean online;
    private String description;
}
