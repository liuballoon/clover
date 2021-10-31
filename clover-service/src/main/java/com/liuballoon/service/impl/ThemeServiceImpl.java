/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:23
 */
package com.liuballoon.service.impl;

import com.liuballoon.common.exception.http.NotFoundException;
import com.liuballoon.mapper.ThemeMapper;
import com.liuballoon.pojo.model.ThemeDO;
import com.liuballoon.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public List<ThemeDO> getThemesByNames(List<String> names) {
        List<ThemeDO> themes = this.themeMapper.selectThemesByNames(names);
        if (themes.isEmpty()) {
            throw new NotFoundException(20005);
        }
        return themes;
    }
}