/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 22:14
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("banner")
public class BannerDO extends BaseDO {
    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;
}
