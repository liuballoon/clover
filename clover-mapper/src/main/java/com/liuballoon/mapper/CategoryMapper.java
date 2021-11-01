/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 0:10
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.pojo.model.CategoryDO;
import com.liuballoon.pojo.vo.GridCategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {
    /**
     * 获取所有宫格分类
     *
     * @return
     */
    List<GridCategoryVO> getAllGridCategory();
}
