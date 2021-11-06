/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/6 21:43
 */
package com.liuballoon.service;

import com.liuballoon.pojo.vo.NavigationVO;

import java.util.List;

public interface NavigationService {
    /**
     * 获取所有导航
     *
     * @return
     */
    List<NavigationVO> getAllNavigation();
}
