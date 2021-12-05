/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 13:50
 */
package com.liuballoon.service;

import com.liuballoon.pojo.vo.SpuPreviewVO;

import java.util.List;

public interface SpuService {
    /**
     * 分页获取所有商品
     *
     * @param page 页码
     * @param size 每页的数据量
     * @return
     */
    List<SpuPreviewVO> getSpuPaging(Integer page, Integer size);
}
