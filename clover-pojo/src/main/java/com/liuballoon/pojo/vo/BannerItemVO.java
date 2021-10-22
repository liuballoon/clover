/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/22 10:13
 */
package com.liuballoon.pojo.vo;

import com.liuballoon.pojo.model.BannerItemDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class BannerItemVO {
    private String id;
    private String coverImg;
    private Integer type;
    private String keyword;
    private Integer sort;

    public BannerItemVO(BannerItemDO bannerItemDO) {
        BeanUtils.copyProperties(bannerItemDO, this);
    }
}
