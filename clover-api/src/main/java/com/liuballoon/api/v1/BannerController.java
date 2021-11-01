/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:59
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.vo.BannerVO;
import com.liuballoon.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api(tags = "轮播图")
@Validated
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "获取轮播图", notes = "根据名称获取轮播图")
    @GetMapping("/name/{name}")
    public Result getBanner(@PathVariable @NotNull String name) {
        BannerVO bannerVO = this.bannerService.getBannerByName(name);
        return Result.success(bannerVO);
    }
}
