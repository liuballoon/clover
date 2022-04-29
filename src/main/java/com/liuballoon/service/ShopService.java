/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/4/29 13:35
 */
package com.liuballoon.service;

import com.liuballoon.vo.ShopDetailVO;

public interface ShopService {
    /**
     * 根据店铺主键获取店铺详情
     *
     * @param shopId 店铺主键
     * @return
     */
    ShopDetailVO getShopDetailById(String shopId);
}
