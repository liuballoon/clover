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
    private String name;
    private String templateName;
    private String coverImg;
    private String description;
}
