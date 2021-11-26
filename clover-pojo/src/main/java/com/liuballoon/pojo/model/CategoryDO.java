/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:10
 */
package com.liuballoon.pojo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("category")
public class CategoryDO extends BaseDO {
    private String pid;
    private String name;
    private String coverImg;
    private Boolean online;
    private Boolean display;
    private Integer sort;
}
