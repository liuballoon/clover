/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/16 20:42
 */
package com.liuballoon.api;

import com.liuballoon.core.auth.LocalUser;
import com.liuballoon.core.response.Result;
import com.liuballoon.dto.SkuDTO;
import com.liuballoon.service.CartService;
import com.liuballoon.vo.CartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "购物车")
@Validated
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation(value = "获取购物车")
    @GetMapping
    public Result getCart() {
        String userId = LocalUser.get().getId();
        List<CartVO> carts = this.cartService.getCartByUserId(userId);
        return Result.success(carts);
    }

    @ApiOperation(value = "添加商品到购物车")
    @PostMapping("/add")
    public Result addCart(@RequestBody @Validated SkuDTO skuDTO) {
        this.cartService.addSkuToCart(skuDTO);
        return Result.success("添加购物车成功");
    }

    @ApiOperation(value = "修改购物车中的商品")
    @PutMapping("/update")
    public Result updateCart(@RequestBody @Validated SkuDTO skuDTO) {
        this.cartService.updateSkuInCart(skuDTO);
        return Result.success("修改成功");
    }

    @ApiOperation(value = "根据购物车主键删除购物车中的商品")
    @PutMapping("/delete/{cartId}")
    public Result deleteCart(@PathVariable @NotNull String cartId) {
        this.cartService.deleteSkuFromCart(cartId);
        return Result.success("删除成功");
    }
}
