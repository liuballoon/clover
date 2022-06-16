/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/12 11:48
 */
package com.liuballoon.es.index;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
public abstract class BaseIndex {
    @Id
    @Field(store = true, type = FieldType.Text, index = false)
    private String id;
}
