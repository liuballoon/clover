/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 20:17
 */
package com.liuballoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddressDTO {
    private String id;

    @NotBlank(message = "收件人不能为空")
    private String receiver;

    @NotBlank(message = "联系方式不能为空")
    private String phone;

    @NotBlank(message = "省份代码不能为空")
    private String provinceCode;

    @NotBlank(message = "省份不能为空")
    private String province;

    @NotBlank(message = "城市代码不能为空")
    private String cityCode;

    @NotBlank(message = "城市不能为空")
    private String city;

    @NotBlank(message = "区县代码不能为空")
    private String districtCode;

    @NotBlank(message = "区县不能为空")
    private String district;

    @NotBlank(message = "详细地址不能为空")
    private String detail;

    private Boolean defaultAddress;
}
