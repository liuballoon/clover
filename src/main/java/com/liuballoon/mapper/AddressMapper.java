/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 14:10
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.AddressDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddressMapper extends BaseMapper<AddressDO> {
    /**
     * 根据用户主键设置用户的所有收货地址为非默认地址
     *
     * @param userId 用户主键
     */
    void updateAddressNotDefaultByUserId(@Param("userId") String userId);

    /**
     * 根据收货地址主键软删除收货地址
     *
     * @param addressId 收货地址主键
     */
    void deleteAddressById(@Param("addressId") String addressId);
}
