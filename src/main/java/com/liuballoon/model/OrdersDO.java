/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:21
 */
package com.liuballoon.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDO extends BaseDO {
    private String orderNum;
    private Boolean online;
    private String description;
}
