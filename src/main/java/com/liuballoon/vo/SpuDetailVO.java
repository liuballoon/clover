/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/12/22 19:26
 */
package com.liuballoon.vo;

import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpuDetailVO {
    private String id;
    private String shopId;
    private String title;
    private String price;
    private String discountPrice;
    private String tags;
    private String description;
    private List<String> displayImages;
    private List<String> introduceImages;
    private List<SkuVO> skuList;
}
