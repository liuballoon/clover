/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 14:09
 */
package com.liuballoon.service;

import com.liuballoon.common.pojo.Paging;
import com.liuballoon.dto.AddressDTO;
import com.liuballoon.vo.AddressVO;

public interface AddressService {
    /**
     * 根据用户主键分页获取所有的收货地址
     *
     * @param userId  用户主键
     * @param pageNum 页码
     * @param size    每页的数据量
     * @return
     */
    Paging<AddressVO> getAddressPaging(String userId, int pageNum, int size);

    /**
     * 创建收货地址
     *
     * @param addressDTO 收货地址数据
     */
    void createAddress(AddressDTO addressDTO);

    /**
     * 修改收货地址
     *
     * @param addressDTO 收货地址数据
     */
    void updateAddress(AddressDTO addressDTO);

    /**
     * 根据收货地址主键删除地址
     *
     * @param addressId 收货地址主键
     */
    void deleteAddressById(String addressId);
}
