/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/28 23:35
 */
package com.liuballoon.pojo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThemeDO extends BaseDO {
    private String name;
    private String templateName;
    private String coverImg;
    private Boolean online;
    private String description;
}
