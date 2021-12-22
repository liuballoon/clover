/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:50
 */
package com.liuballoon.service;

import com.liuballoon.common.pojo.Paging;
import com.liuballoon.pojo.vo.SpuDetailVO;
import com.liuballoon.pojo.vo.SpuPreviewVO;

public interface SpuService {
    /**
     * 分页获取所有商品
     *
     * @param pageNum 页码
     * @param size 每页的数据量
     * @return
     */
    Paging<SpuPreviewVO> getSpuPaging(int pageNum, int size);

    /**
     * 根据商品id获取商品详情
     *
     * @param spuId 商品id
     * @return
     */
    SpuDetailVO getSpuDetailById(String spuId);
}
