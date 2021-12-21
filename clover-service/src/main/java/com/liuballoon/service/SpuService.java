/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:50
 */
package com.liuballoon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liuballoon.pojo.model.SpuDO;

public interface SpuService {
    /**
     * 分页获取所有商品
     *
     * @param pageNum 页码
     * @param size 每页的数据量
     * @return
     */
    IPage<SpuDO> getSpuPaging(Integer pageNum, Integer size);
}
