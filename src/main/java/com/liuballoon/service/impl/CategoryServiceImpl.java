/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:09
 */
package com.liuballoon.service.impl;

import com.liuballoon.core.exception.http.NotFoundException;
import com.liuballoon.mapper.CategoryMapper;
import com.liuballoon.model.CategoryDO;
import com.liuballoon.service.CategoryService;
import com.liuballoon.vo.CategoryVO;
import com.liuballoon.vo.RootCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<RootCategoryVO> getRootCategories() {
        List<CategoryDO> rootCategories = this.categoryMapper.selectRootCategories();
        if (rootCategories.isEmpty()) {
            throw new NotFoundException(10304);
        }
        return rootCategories.stream()
                .map(RootCategoryVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryVO> getSubCategories(String rootId) {
        List<CategoryVO> subCategories = this.categoryMapper.selectSubCategoriesByRootId(rootId);
        if (subCategories.isEmpty()) {
            throw new NotFoundException(10305);
        }
        return subCategories;
    }
}
