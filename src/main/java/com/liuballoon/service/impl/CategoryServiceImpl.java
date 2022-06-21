/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:09
 */
package com.liuballoon.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liuballoon.common.utils.RedisOperator;
import com.liuballoon.common.utils.Serializer;
import com.liuballoon.mapper.CategoryMapper;
import com.liuballoon.service.CategoryService;
import com.liuballoon.vo.CategoryVO;
import com.liuballoon.vo.RootCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String KEY = "category";

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisOperator redisOperator;

    @Override
    public List<RootCategoryVO> getRootCategories() {
        String categories = this.redisOperator.get(KEY);
        if (categories == null) {
            List<RootCategoryVO> rootCategories = this.categoryMapper.selectRootCategories();
            if (!rootCategories.isEmpty()) {
                this.redisOperator.set(KEY, Serializer.objectToJson(rootCategories));
            }
            return rootCategories;
        }
        return Serializer.jsonToObject(categories, new TypeReference<>() {
        });
    }

    @Override
    public List<CategoryVO> getSubCategories(String rootId) {
        String subs = this.redisOperator.get(rootId);
        if (subs == null) {
            List<CategoryVO> subCategories = this.categoryMapper.selectSubCategoriesByRootId(rootId);
            if (!subCategories.isEmpty()) {
                this.redisOperator.set(rootId, Serializer.objectToJson(subCategories));
            }
            return subCategories;
        }
        return Serializer.jsonToObject(subs, new TypeReference<>() {
        });
    }
}
