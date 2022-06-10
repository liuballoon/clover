/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:10
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("category")
public class CategoryDO extends BaseDO {
    /**
     * 父主键
     */
    private String pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 封面图
     */
    private String coverImg;

    /**
     * 是否为默认展示（0否 1是）
     */
    private Boolean defaultDisplay;

    /**
     * 排序
     */
    private Integer sort;
}
