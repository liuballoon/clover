/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 14:10
 */
package com.liuballoon.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("spu")
public class SpuDO extends BaseDO {
    private String shopId;
    private String title;
    private String coverImg;
    private String price;
    private String discountPrice;
    private String tags;
    private String description;
}
