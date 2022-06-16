/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/12 11:26
 */
package com.liuballoon.es.index;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "spu", createIndex = false)
public class SpuIndex extends BaseIndex {
    private String title;
    private String coverImg;
    private String price;
    private String discountPrice;
    private String tags;
    private String description;
}
