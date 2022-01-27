/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:50
 */
package com.liuballoon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuballoon.common.pojo.Paging;
import com.liuballoon.core.exception.http.NotFoundException;
import com.liuballoon.mapper.SpuMapper;
import com.liuballoon.model.SpuDO;
import com.liuballoon.service.SpuService;
import com.liuballoon.vo.SpuDetailVO;
import com.liuballoon.vo.SpuPreviewVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public Paging<SpuPreviewVO> getSpuPaging(int pageNum, int size) {
        var queryWrapper = new QueryWrapper<SpuDO>();
        queryWrapper.eq("online", true).isNull("delete_time");
        var page = new Page<SpuDO>(pageNum, size, false);
        // todo: 待优化
        IPage<SpuPreviewVO> paging = this.spuMapper.selectPage(page, queryWrapper).convert(spuDO -> {
            var spuPreview = new SpuPreviewVO();
            BeanUtils.copyProperties(spuDO, spuPreview);
            return spuPreview;
        });
        return new Paging<>(paging.getCurrent(), paging.getSize(), paging.getRecords().size(), paging.getRecords());
    }

    @Override
    public SpuDetailVO getSpuDetailById(String spuId) {
        return this.spuMapper.getSpuDetailById(spuId).orElseThrow(() -> new NotFoundException(50004));
    }
}
