/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/6 21:43
 */
package com.liuballoon.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liuballoon.common.utils.RedisOperator;
import com.liuballoon.common.utils.Serializer;
import com.liuballoon.mapper.NavigationMapper;
import com.liuballoon.service.NavigationService;
import com.liuballoon.vo.NavigationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    private static final String KEY = "navigation";

    @Autowired
    private NavigationMapper navigationMapper;

    @Autowired
    private RedisOperator redisOperator;

    @Override
    public List<NavigationVO> getNavigations() {
        String navigations = this.redisOperator.get(KEY);
        if (navigations == null) {
            List<NavigationVO> navigationList = this.navigationMapper.selectNavigations();
            if (!navigationList.isEmpty()) {
                this.redisOperator.set(KEY, Serializer.objectToJson(navigationList));
            }
            return navigationList;
        }
        return Serializer.jsonToObject(navigations, new TypeReference<>() {
        });
    }
}
