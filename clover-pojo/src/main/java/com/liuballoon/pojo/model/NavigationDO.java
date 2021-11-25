/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/6 21:44
 */
package com.liuballoon.pojo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("navigation")
public class NavigationDO extends BaseDO {
    private String name;
    private String coverImg;
    private Integer type;
    private String keyword;
    private Boolean online;
}
