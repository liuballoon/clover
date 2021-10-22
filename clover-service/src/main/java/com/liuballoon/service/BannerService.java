/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:39
 */
package com.liuballoon.service;

import com.liuballoon.pojo.vo.BannerVO;

public interface BannerService {
    /**
     * 根据名称获取轮播图
     *
     * @param name 名称
     * @return
     */
    BannerVO getBannerByName(String name);
}
