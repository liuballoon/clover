/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:38
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.pojo.model.ThemeDO;
import com.liuballoon.pojo.vo.ThemeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemeMapper extends BaseMapper<ThemeDO> {
    /**
     * 根据一组名称获取一组专题
     *
     * @param names 一组名称
     * @return
     */
    List<ThemeVO> selectThemesByNames(List<String> names);
}
