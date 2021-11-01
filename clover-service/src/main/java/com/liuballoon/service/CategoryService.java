/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:09
 */
package com.liuballoon.service;

import com.liuballoon.pojo.vo.GridCategoryVO;

import java.util.List;

public interface CategoryService {
    /**
     * 获取所有宫格分类
     *
     * @return
     */
    List<GridCategoryVO> getAllGridCategory();
}
