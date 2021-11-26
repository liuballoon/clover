/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:09
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.exception.http.NotFoundException;
import com.liuballoon.mapper.CategoryMapper;
import com.liuballoon.pojo.model.CategoryDO;
import com.liuballoon.pojo.vo.CategoryVO;
import com.liuballoon.pojo.vo.RootCategoryVO;
import com.liuballoon.service.CategoryService;
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
            throw new NotFoundException(30004);
        }
        return rootCategories.stream()
                .map(RootCategoryVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryVO> getSubCategories(String rootId) {
        List<CategoryVO> subCategories = this.categoryMapper.selectSubCategoriesByRootId(rootId);
        if (subCategories.isEmpty()) {
            throw new NotFoundException(30005);
        }
        return subCategories;
    }
}
