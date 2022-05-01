/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 14:09
 */
package com.liuballoon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuballoon.common.pojo.Paging;
import com.liuballoon.core.auth.LocalUser;
import com.liuballoon.dto.AddressDTO;
import com.liuballoon.mapper.AddressMapper;
import com.liuballoon.model.AddressDO;
import com.liuballoon.service.AddressService;
import com.liuballoon.vo.AddressVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Paging<AddressVO> getAddressPaging(String userId, int pageNum, int size) {
        var queryWrapper = new QueryWrapper<AddressDO>();
        queryWrapper.isNull("delete_time");
        var page = new Page<AddressDO>(pageNum, size);
        IPage<AddressVO> paging = this.addressMapper.selectPage(page, queryWrapper).convert(addressDO -> {
            var addressVO = new AddressVO();
            BeanUtils.copyProperties(addressDO, addressVO);
            return addressVO;
        });
        return new Paging<>(paging.getCurrent(), paging.getSize(), paging.getRecords().size(), paging.getRecords());
    }

    @Override
    public void createAddress(AddressDTO addressDTO) {
        var address = new AddressDO();
        BeanUtils.copyProperties(addressDTO, address);
        address.setUserId(LocalUser.get().getId());  // 填充当前用户主键
        this.addressMapper.insert(address);
    }

    @Transactional
    @Override
    public void updateAddress(AddressDTO addressDTO) {
        var address = new AddressDO();
        BeanUtils.copyProperties(addressDTO, address);
        if (address.getDefaultAddress()) {
            this.setAddressNotDefault();
        }
        this.addressMapper.updateById(address);
    }

    @Override
    public void deleteAddressById(String addressId) {
        var updateWrapper = new UpdateWrapper<AddressDO>();
        // TODO: 用更新包装器软删除收货地址
    }

    /**
     * 设置当前用户的所有收货地址为非默认地址
     */
    private void setAddressNotDefault() {
        this.addressMapper.updateAddressNotDefaultByUserId(LocalUser.get().getId());
    }
}
