/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:39
 */
package com.liuballoon.service;

import com.liuballoon.vo.BannerVO;

public interface BannerService {
    /**
     * 根据轮播图名称获取轮播图
     *
     * @param bannerName 轮播图名称
     * @return
     */
    BannerVO getBannerByName(String bannerName);
}
