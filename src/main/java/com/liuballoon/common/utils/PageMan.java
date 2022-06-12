/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 15:24
 */
package com.liuballoon.common.utils;

import com.liuballoon.common.pojo.PageParam;

/**
 * 分页工具
 */
public class PageMan {

    public static PageParam convertParams(int start, int count) {
        int pageNum = start / count + 1;
        return PageParam.builder()
                .pageNum(pageNum)
                .size(count)
                .build();
    }
}
