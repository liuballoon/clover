/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/11/6 21:43
 */
package com.liuballoon.service.impl;

import com.liuballoon.core.exception.http.NotFoundException;
import com.liuballoon.mapper.NavigationMapper;
import com.liuballoon.service.NavigationService;
import com.liuballoon.vo.NavigationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private NavigationMapper navigationMapper;

    @Override
    public List<NavigationVO> getNavigations() {
        List<NavigationVO> navigations = this.navigationMapper.selectNavigations();
        if (navigations.isEmpty()) {
            throw new NotFoundException(10404);
        }
        return navigations;
    }
}
