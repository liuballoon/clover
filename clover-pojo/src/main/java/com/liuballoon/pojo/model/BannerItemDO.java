/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 12:52
 */
package com.liuballoon.pojo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerItemDO extends BaseDO {
    private String id;
    private String bannerId;
    private String coverImg;
    private Integer type;
    private String keyword;
    private Integer sort;
}
