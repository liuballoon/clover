/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 22:14
 */
package com.liuballoon.pojo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerDO extends BaseDO {
    private String name;
    private Boolean online;
    private String description;
}
