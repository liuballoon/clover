/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/19 23:39
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.exception.http.NotFoundException;
import com.liuballoon.common.utils.RedisOperator;
import com.liuballoon.common.utils.Serializer;
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

    @Autowired
    private RedisOperator redisOperator;

    @Override
    public BannerVO getBannerByName(String name) {
        String banner = this.redisOperator.get(name);
        if (banner == null) {
            BannerVO bannerVO = this.getBannerFromDB(name);
            this.redisOperator.set(name, Serializer.objectToJson(bannerVO));
            return bannerVO;
        }
        return Serializer.jsonToObject(banner, BannerVO.class);
    }

    /**
     * 从数据库获取轮播图
     *
     * @param name 轮播图名称
     * @return 轮播图
     */
    private BannerVO getBannerFromDB(String name) {
        BannerDO bannerDO = this.bannerMapper.selectBannerByName(name).orElseThrow(() -> new NotFoundException(10004));
        List<BannerItemVO> items = this.bannerItemMapper.selectItemsByBannerId(bannerDO.getId());
        return new BannerVO(bannerDO, items);
    }
}
