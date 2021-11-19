/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:39
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.exception.http.NotFoundException;
import com.liuballoon.mapper.BannerItemMapper;
import com.liuballoon.mapper.BannerMapper;
import com.liuballoon.pojo.model.BannerDO;
import com.liuballoon.pojo.vo.BannerItemVO;
import com.liuballoon.pojo.vo.BannerVO;
import com.liuballoon.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemMapper bannerItemMapper;

    @Override
    public BannerVO getBannerByName(String name) {
        BannerDO bannerDO = this.bannerMapper.selectBannerByName(name).orElseThrow(() -> new NotFoundException(10005));
        List<BannerItemVO> items = this.bannerItemMapper.selectItemsByBannerId(bannerDO.getId());
        return new BannerVO(bannerDO, items);
    }
}
