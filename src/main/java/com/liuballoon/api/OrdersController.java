/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/24 13:33
 */
package com.liuballoon.api;

import com.liuballoon.core.response.Result;
import com.liuballoon.dto.OrderDTO;
import com.liuballoon.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单")
@Validated
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "根据订单信息下单")
    @PostMapping("/place")
    public Result placeOrder(@RequestBody @Validated OrderDTO orderDTO) {
        this.ordersService.placeOrder(orderDTO);
        return Result.success("下单成功");
    }
}
