/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/16 20:40
 */
package com.liuballoon.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDO extends BaseDO {
    /**
     * 用户主键
     */
    private String userId;

    /**
     * 店铺主键
     */
    private String shopId;

    /**
     * 单品主键
     */
    private String skuId;

    /**
     * 单品
     */
    private String item;

    /**
     * 总数
     */
    private Integer total;
}
