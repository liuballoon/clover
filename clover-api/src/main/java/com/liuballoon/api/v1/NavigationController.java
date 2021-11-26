/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/6 21:42
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.vo.NavigationVO;
import com.liuballoon.service.NavigationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "导航")
@RestController
@RequestMapping("/navigation")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @ApiOperation(value = "获取所有导航")
    @GetMapping("/all")
    public Result getNavigations() {
        List<NavigationVO> navigations = this.navigationService.getNavigations();
        return Result.success(navigations);
    }
}
