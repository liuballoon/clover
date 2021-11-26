/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/31 23:58
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.vo.CategoryVO;
import com.liuballoon.pojo.vo.RootCategoryVO;
import com.liuballoon.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "类目")
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取所有一级类目")
    @GetMapping("/root/all")
    public Result getRootCategories() {
        List<RootCategoryVO> rootCategories = this.categoryService.getRootCategories();
        return Result.success(rootCategories);
    }

    @ApiOperation(value = "根据一级类目id获取所有子类目")
    @GetMapping("/root/subs")
    public Result getSubCategories(@RequestParam @NotNull String rootId) {
        List<CategoryVO> subCategories = this.categoryService.getSubCategories(rootId);
        return Result.success(subCategories);
    }
}
