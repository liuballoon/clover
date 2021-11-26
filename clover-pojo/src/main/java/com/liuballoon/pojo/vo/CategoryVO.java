/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/1 9:54
 */
package com.liuballoon.pojo.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CategoryVO {
    private String id;
    private String name;
    private String coverImg;
    List<CategoryVO> subs;
}
