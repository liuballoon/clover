/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 14:10
 */
package com.liuballoon.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDO extends BaseDO {
    private String userId;
    private String name;
    private String phone;
    private String detailAddress;
    private Boolean defaultAddress;
}
