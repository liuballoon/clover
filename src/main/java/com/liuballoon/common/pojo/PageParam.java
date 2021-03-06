/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/28 20:29
 */
package com.liuballoon.common.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PageParam {
    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页的数据量
     */
    private int size;
}
