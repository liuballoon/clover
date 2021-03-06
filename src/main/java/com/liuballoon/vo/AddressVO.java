/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 20:10
 */
package com.liuballoon.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressVO {
    private String id;
    private String receiver;
    private String phone;
    private String provinceCode;
    private String province;
    private String cityCode;
    private String city;
    private String districtCode;
    private String district;
    private String detail;
    private Boolean defaultAddress;
}
