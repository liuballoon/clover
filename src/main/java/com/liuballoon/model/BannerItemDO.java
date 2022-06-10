/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 12:52
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("banner_item")
public class BannerItemDO extends BaseDO {
    /**
     * 轮播图主键
     */
    private String bannerId;

    /**
     * 名称
     */
    private String name;

    /**
     * 封面图
     */
    private String coverImg;

    /**
     * 类型（0商品 1专题 2活动）
     */
    private Integer type;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 排序
     */
    private Integer sort;
}
