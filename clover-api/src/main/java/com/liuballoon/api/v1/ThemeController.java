/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:22
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.vo.ThemeVO;
import com.liuballoon.service.ThemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "专题")
@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @ApiOperation(value = "获取所有专题")
    @GetMapping("/all")
    public Result getThemes() {
        List<ThemeVO> themes = this.themeService.getThemes();
        return Result.success(themes);
    }
}
