/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:49
 */
package com.liuballoon.api.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuballoon.common.pojo.PagingParam;
import com.liuballoon.common.response.Result;
import com.liuballoon.common.utils.PagingMan;
import com.liuballoon.pojo.model.SpuDO;
import com.liuballoon.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品")
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @ApiOperation(value = "分页获取所有商品")
    @GetMapping("/page")
    public Result getSpuPaging(@RequestParam(defaultValue = "1") Integer start,
                               @RequestParam(defaultValue = "10") Integer count) {
        PagingParam param = PagingMan.convertParams(start, count);
        IPage<SpuDO> spuPaging = this.spuService.getSpuPaging(param.getPageNum(), param.getSize());
        return Result.success(spuPaging);
    }
}
