/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:49
 */
package com.liuballoon.api;

import com.liuballoon.common.pojo.PageParam;
import com.liuballoon.common.pojo.Paging;
import com.liuballoon.common.utils.PageMan;
import com.liuballoon.core.response.Result;
import com.liuballoon.service.SpuService;
import com.liuballoon.vo.SpuDetailVO;
import com.liuballoon.vo.SpuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api(tags = "商品")
@Validated
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @ApiOperation(value = "分页获取所有商品")
    @GetMapping("/page")
    public Result getSpuPaging(@RequestParam(required = false, defaultValue = "0") int start,
                               @RequestParam(required = false, defaultValue = "10") int count) {
        PageParam param = PageMan.convertParams(start, count);
        Paging<SpuVO> spuPaging = this.spuService.getSpuPaging(param.getPageNum(), param.getSize());
        return Result.success(spuPaging);
    }

    @ApiOperation(value = "根据商品主键获取商品详情")
    @GetMapping("/detail/{spuId}")
    public Result getSpuDetailById(@PathVariable @NotNull String spuId) {
        SpuDetailVO spuDetail = this.spuService.getSpuDetailById(spuId);
        return Result.success(spuDetail);
    }
}
