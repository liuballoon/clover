/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/21 12:51
 */
package com.liuballoon.pojo.vo;

import com.liuballoon.pojo.model.BannerDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class BannerVO {
    private String id;
    private String name;
    private String description;
    private List<BannerItemVO> items;

    public BannerVO(BannerDO bannerDO, List<BannerItemVO> items) {
        BeanUtils.copyProperties(bannerDO, this);
        this.items = items;
    }
}
