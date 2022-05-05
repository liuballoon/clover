/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/5/5 14:10
 */
package com.liuballoon.api;

import com.liuballoon.core.response.Result;
import com.liuballoon.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collections;

@Api(tags = "搜索")
@Validated
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "根据关键字搜索")
    @GetMapping()
    public Result search(@RequestParam @NotNull String keyword) {
        return Result.success(Collections.emptyList());
    }
}
