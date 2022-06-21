/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/21 23:39
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.OrdersDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<OrdersDO> {
}
