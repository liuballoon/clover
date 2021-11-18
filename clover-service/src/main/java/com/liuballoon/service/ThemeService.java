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
     * 根据一组名称获取一组专题
     *
     * @param names 一组名称
     * @return
     */
    List<ThemeVO> getThemesByNames(List<String> names);
}
