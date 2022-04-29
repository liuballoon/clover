/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 14:08
 */
package com.liuballoon.api;

import com.liuballoon.service.AddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "收货地址")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
}
