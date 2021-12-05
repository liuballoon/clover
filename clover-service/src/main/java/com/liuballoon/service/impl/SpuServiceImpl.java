/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:50
 */
package com.liuballoon.service.impl;

import com.liuballoon.mapper.SpuMapper;
import com.liuballoon.pojo.vo.SpuPreviewVO;
import com.liuballoon.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public List<SpuPreviewVO> getSpuPaging(Integer page, Integer size) {
        return null;
    }
}
