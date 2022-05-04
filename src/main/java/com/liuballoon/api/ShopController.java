/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 13:32
 */
package com.liuballoon.api;

import com.liuballoon.core.response.Result;
import com.liuballoon.service.ShopService;
import com.liuballoon.vo.ShopDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Api(tags = "店铺")
@Validated
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "根据店铺主键获取店铺详情")
    @GetMapping("/detail/{shopId}")
    public Result getShopDetailById(@PathVariable @NotNull String shopId) {
        ShopDetailVO detail = this.shopService.getShopDetailById(shopId);
        return Result.success(detail);
    }
}
