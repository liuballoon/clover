/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2021/10/23 9:22
 */
package com.liuballoon.api.v1;

import com.liuballoon.pojo.model.ThemeDO;
import com.liuballoon.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/names")
    public List<ThemeDO> getThemes(@RequestParam String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        return this.themeService.getThemesByNames(nameList);
    }
}
