/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/6 21:44
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("navigation")
public class NavigationDO extends BaseDO {
    /**
     * 名称
     */
    private String name;

    /**
     * 封面图
     */
    private String coverImg;

    /**
     * 类型（0分类 1专题）
     */
    private Integer type;

    /**
     * 关键字
     */
    private String keyword;
}
