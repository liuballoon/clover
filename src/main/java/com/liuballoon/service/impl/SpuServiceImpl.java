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
import com.liuballoon.mapper.SkuMapper;
import com.liuballoon.mapper.SpuMapper;
import com.liuballoon.model.SpuDO;
import com.liuballoon.service.SpuService;
import com.liuballoon.vo.SkuVO;
import com.liuballoon.vo.SpuDetailVO;
import com.liuballoon.vo.SpuPreviewVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Paging<SpuPreviewVO> getSpuPaging(int pageNum, int size) {
        var queryWrapper = new QueryWrapper<SpuDO>();
        queryWrapper.eq("status", 1);
        var page = new Page<SpuDO>(pageNum, size, false);
        IPage<SpuPreviewVO> paging = this.spuMapper.selectPage(page, queryWrapper).convert(spuDO -> {
            var spuPreviewVO = new SpuPreviewVO();
            BeanUtils.copyProperties(spuDO, spuPreviewVO);
            return spuPreviewVO;
        });
        return new Paging<>(paging.getCurrent(), paging.getSize(), paging.getRecords().size(), paging.getRecords());
    }

    @Override
    public SpuDetailVO getSpuDetailById(String spuId) {
        SpuDetailVO spuDetail = this.spuMapper.getSpuDetailById(spuId).orElseThrow(() -> new NotFoundException(50004));
        List<SkuVO> skuList = this.skuMapper.selectSkuListBySpuId(spuDetail.getId());
        return spuDetail.toBuilder()
                .skuList(skuList)
                .build();
    }
}
