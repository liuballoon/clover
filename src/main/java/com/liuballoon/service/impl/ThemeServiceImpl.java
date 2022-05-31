/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:23
 */
package com.liuballoon.service.impl;

import com.liuballoon.core.exception.http.NotFoundException;
import com.liuballoon.mapper.ThemeMapper;
import com.liuballoon.service.ThemeService;
import com.liuballoon.vo.ThemeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public List<ThemeVO> getThemes() {
        List<ThemeVO> themes = this.themeMapper.selectThemes();
        if (themes.isEmpty()) {
            throw new NotFoundException(10104);
        }
        return themes;
    }
}
