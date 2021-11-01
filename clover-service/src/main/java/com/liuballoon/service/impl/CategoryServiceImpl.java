/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:09
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.exception.http.NotFoundException;
import com.liuballoon.mapper.CategoryMapper;
import com.liuballoon.pojo.vo.GridCategoryVO;
import com.liuballoon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<GridCategoryVO> getAllGridCategory() {
        List<GridCategoryVO> gridCategories = this.categoryMapper.getAllGridCategory();
        if (gridCategories.isEmpty()) {
            throw new NotFoundException(30005);
        }
        return gridCategories;
    }
}
