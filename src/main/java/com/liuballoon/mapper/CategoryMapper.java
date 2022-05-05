/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:10
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.model.CategoryDO;
import com.liuballoon.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {
    /**
     * 获取所有一级类目
     *
     * @return
     */
    List<CategoryDO> selectRootCategories();

    /**
     * 根据一级类目id获取所有子类目
     *
     * @param rootId 一级类目id
     * @return
     */
    List<CategoryVO> selectSubCategoriesByRootId(@Param("rootId") String rootId);
}