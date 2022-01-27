/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:09
 */
package com.liuballoon.service;

import com.liuballoon.vo.CategoryVO;
import com.liuballoon.vo.RootCategoryVO;

import java.util.List;

public interface CategoryService {
    /**
     * 获取所有一级类目
     *
     * @return
     */
    List<RootCategoryVO> getRootCategories();

    /**
     * 根据一级类目id获取所有子类目
     *
     * @param rootId 一级类目id
     * @return
     */
    List<CategoryVO> getSubCategories(String rootId);
}
