/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/12/22 19:26
 */
package com.liuballoon.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpuDetailVO {
    private String id;
    private String title;
    private String price;
    private String discountPrice;
    private String tags;
    private String description;
    private List<String> displayImages;
    private List<String> introduceImages;
}
