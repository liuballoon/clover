/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:59
 */
package com.liuballoon.api.v1;

import com.liuballoon.pojo.vo.BannerVO;
import com.liuballoon.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public BannerVO getBanner(@PathVariable @NotNull String name) {
        return this.bannerService.getBannerByName(name);
    }
}
