/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/31 23:58
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.vo.GridCategoryVO;
import com.liuballoon.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "分类")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取宫格分类", notes = "获取所有宫格分类")
    @GetMapping("/grid/all")
    public Result getGridCategory() {
        List<GridCategoryVO> gridCategories = this.categoryService.getAllGridCategory();
        return Result.success(gridCategories);
    }
}
