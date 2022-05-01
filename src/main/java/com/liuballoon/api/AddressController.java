/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 14:08
 */
package com.liuballoon.api;

import com.liuballoon.common.enums.UserLevel;
import com.liuballoon.common.pojo.PageParam;
import com.liuballoon.common.pojo.Paging;
import com.liuballoon.common.utils.PageMan;
import com.liuballoon.core.auth.AccessScope;
import com.liuballoon.core.response.Result;
import com.liuballoon.dto.AddressDTO;
import com.liuballoon.service.AddressService;
import com.liuballoon.vo.AddressVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "收货地址")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "根据用户主键分页获取所有收货地址")
    @AccessScope(UserLevel.GENERAL)
    @GetMapping("/all/{userId}")
    public Result getAddresses(@PathVariable String userId,
                               @RequestParam(defaultValue = "0") int start,
                               @RequestParam(defaultValue = "10") int count) {
        PageParam param = PageMan.convertParams(start, count);
        Paging<AddressVO> addressPaging = this.addressService.getAddressPaging(userId, param.getPageNum(), param.getSize());
        return Result.success(addressPaging);
    }

    @ApiOperation(value = "创建收货地址")
    @AccessScope(UserLevel.GENERAL)
    @PostMapping("/create")
    public Result createAddress(@RequestBody AddressDTO addressDTO) {
        this.addressService.createAddress(addressDTO);
        return Result.success("创建成功");

    }

    @ApiOperation(value = "修改收货地址")
    @AccessScope(UserLevel.GENERAL)
    @PutMapping("/update")
    public Result updateAddress(@RequestBody AddressDTO addressDTO) {
        this.addressService.updateAddress(addressDTO);
        return Result.success("修改成功");
    }

    @ApiOperation(value = "根据收货地址主键删除地址")
    @AccessScope(UserLevel.GENERAL)
    @PutMapping("/delete/{addressId}")
    public Result deleteAddressById(@PathVariable String addressId) {
        this.addressService.deleteAddressById(addressId);
        return Result.success("删除成功");
    }
}
