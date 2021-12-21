/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:50
 */
package com.liuballoon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuballoon.mapper.SpuMapper;
import com.liuballoon.pojo.model.SpuDO;
import com.liuballoon.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public IPage<SpuDO> getSpuPaging(Integer pageNum, Integer size) {
//        var queryWrapper = new LambdaQueryWrapper<SpuDO>();
//        queryWrapper.isNull(SpuDO::getDeleteTime);
        var queryWrapper = new QueryWrapper<SpuDO>();
        queryWrapper.isNull("delete_time");
        Page<SpuDO> page = new Page<>(pageNum, size);
        IPage<SpuDO> paging = this.spuMapper.selectPage(page, queryWrapper);
        return paging;
    }
}
