/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:22
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.model.ThemeDO;
import com.liuballoon.service.ThemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Api(tags = "专题")
@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @ApiOperation(value = "根据一组名称获取所有专题")
    @GetMapping("/names")
    public Result getThemesByNames(@RequestParam @NotNull String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        List<ThemeDO> themes = this.themeService.getThemesByNames(nameList);
        return Result.success(themes);
    }
}
