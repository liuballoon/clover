/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 15:24
 */
package com.liuballoon.common.utils;

import com.liuballoon.common.pojo.PagingParam;

/**
 * 分页工具类
 */
public class PagingMan {

    public static PagingParam convertParams(Integer start, Integer count) {
        int page = start / count;
        return PagingParam.builder()
                .page(page)
                .size(count)
                .build();
    }
}
