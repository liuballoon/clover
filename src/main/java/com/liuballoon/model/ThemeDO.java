/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/28 23:35
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("theme")
public class ThemeDO extends BaseDO {
    /**
     * 名称
     */
    private String name;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 封面图
     */
    private String coverImg;

    /**
     * 描述
     */
    private String description;
}
