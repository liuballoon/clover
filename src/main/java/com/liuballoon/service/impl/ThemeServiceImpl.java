/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:23
 */
package com.liuballoon.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liuballoon.common.utils.RedisOperator;
import com.liuballoon.common.utils.Serializer;
import com.liuballoon.mapper.ThemeMapper;
import com.liuballoon.service.ThemeService;
import com.liuballoon.vo.ThemeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    private static final String KEY = "theme";

    @Autowired
    private ThemeMapper themeMapper;

    @Autowired
    private RedisOperator redisOperator;

    @Override
    public List<ThemeVO> getThemes() {
        String themes = this.redisOperator.get(KEY);
        if (themes == null) {
            List<ThemeVO> themeList = this.themeMapper.selectThemes();
            if (!themeList.isEmpty()) {
                this.redisOperator.set(KEY, Serializer.objectToJson(themeList));
            }
            return themeList;
        }
        return Serializer.jsonToObject(themes, new TypeReference<>() {
        });
    }
}
