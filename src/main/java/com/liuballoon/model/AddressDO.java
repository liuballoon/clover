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
    /**
     * 用户主键
     */
    private String userId;

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 省份代码
     */
    private String provinceCode;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市代码
     */
    private String cityCode;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县代码
     */
    private String districtCode;

    /**
     * 区县
     */
    private String district;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 是否为默认地址（0否 1是）
     */
    private Boolean defaultAddress;
}
