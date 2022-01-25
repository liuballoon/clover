/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/1/25 11:17
 */
package com.liuballoon.api.v1;

import com.liuballoon.common.response.Result;
import com.liuballoon.pojo.dto.LoginDTO;
import com.liuballoon.pojo.vo.TokenVO;
import com.liuballoon.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "授权")
@Validated
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginDTO loginDTO) {
        TokenVO token = this.authService.login(loginDTO);
        return Result.success(token);
    }
}
