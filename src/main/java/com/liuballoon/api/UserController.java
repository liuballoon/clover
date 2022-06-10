/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/10 21:20
 */
package com.liuballoon.api;

import com.liuballoon.core.auth.LocalUser;
import com.liuballoon.core.response.Result;
import com.liuballoon.dto.UserInfoDTO;
import com.liuballoon.model.UserDO;
import com.liuballoon.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户")
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public Result getUserInfo() {
        UserDO user = LocalUser.get();
        return Result.success(user);
    }

    @ApiOperation(value = "修改用户信息")
    @PutMapping("/update")
    public Result updateUserInfo(@RequestBody @Validated UserInfoDTO userInfoDTO) {
        this.userService.updateUserInfo(userInfoDTO);
        return Result.success("修改成功");
    }
}
