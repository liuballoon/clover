/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 13:36
 */
package com.liuballoon.service.impl;

import com.liuballoon.core.exception.http.NotFoundException;
import com.liuballoon.mapper.ShopMapper;
import com.liuballoon.service.ShopService;
import com.liuballoon.vo.ShopDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public ShopDetailVO getShopDetailById(String shopId) {
        return this.shopMapper.selectShopDetailById(shopId).orElseThrow(() -> new NotFoundException(50104));
    }
}
