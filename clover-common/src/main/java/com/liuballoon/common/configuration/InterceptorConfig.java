package com.liuballoon.common.configuration;

import com.liuballoon.common.auth.PermissionInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     *
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor());
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
