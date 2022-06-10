/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 14:10
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("spu")
public class SpuDO extends BaseDO {
    /**
     * 店铺主键
     */
    private String shopId;

    /**
     * 类目主键
     */
    private String categoryId;

    /**
     * 名称
     */
    private String name;

    /**
     * 封面图
     */
    private String coverImg;

    /**
     * 价格
     */
    private String price;

    /**
     * 折扣价
     */
    private String discountPrice;

    /**
     * 标签
     */
    private String tags;

    /**
     * 描述
     */
    private String description;
}
