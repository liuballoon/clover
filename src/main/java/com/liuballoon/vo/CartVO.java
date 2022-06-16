/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/16 20:50
 */
package com.liuballoon.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
    private String userId;
    private String shopId;
    private String skuId;
    private String item;
    private Integer total;
}
