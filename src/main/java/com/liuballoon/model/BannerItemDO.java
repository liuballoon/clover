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
    private String id;
    private String bannerId;
    private String name;
    private String coverImg;
    private Integer type;
    private String keyword;
    private Integer sort;
}