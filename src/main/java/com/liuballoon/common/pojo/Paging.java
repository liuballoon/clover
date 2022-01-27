/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/12/22 19:51
 */
package com.liuballoon.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Paging<T> {
    private long pageNum;
    private long size;
    private long currentSize;
    private List<T> items;
}
