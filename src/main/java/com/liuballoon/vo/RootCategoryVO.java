/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/21 20:37
 */
package com.liuballoon.vo;

import com.liuballoon.model.CategoryDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class RootCategoryVO {
    private String id;
    private String name;
    private String coverImg;
    private Boolean display;

    public RootCategoryVO(CategoryDO categoryDO) {
        BeanUtils.copyProperties(categoryDO, this);
    }
}
