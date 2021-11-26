/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/10 23:39
 */
package com.liuballoon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuballoon.pojo.model.NavigationDO;
import com.liuballoon.pojo.vo.NavigationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NavigationMapper extends BaseMapper<NavigationDO> {
    /**
     * 获取所有导航
     *
     * @return
     */
    List<NavigationVO> selectNavigations();
}
