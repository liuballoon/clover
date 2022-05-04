/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/2/23 16:58
 */
package com.liuballoon.vo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liuballoon.common.utils.Serializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class SkuVO {
    private String id;
    private String spuId;
    private String title;
    private String previewImg;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private String spec;
    private Integer stock;
    private String description;

    public List<SpecVO> getSpec() {
        if (this.spec == null) {
            return Collections.emptyList();
        }
        return Serializer.jsonToObject(this.spec, new TypeReference<>() {
        });
    }
}
