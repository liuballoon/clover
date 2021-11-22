/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:23
 */
package com.liuballoon.service;

import com.liuballoon.pojo.vo.ThemeVO;

import java.util.List;

public interface ThemeService {
    /**
     * 获取所有专题
     *
     * @return
     */
    List<ThemeVO> getAllThemes();
}
