/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:59
 */
package com.liuballoon.api;

import com.liuballoon.core.response.Result;
import com.liuballoon.service.BannerService;
import com.liuballoon.vo.BannerVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Api(tags = "轮播图")
@Validated
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "根据轮播图名称获取轮播图")
    @GetMapping("/name/{bannerName}")
    public Result getBannerByName(@PathVariable @NotNull String bannerName) {
        BannerVO bannerVO = this.bannerService.getBannerByName(bannerName);
        return Result.success(bannerVO);
    }
}
