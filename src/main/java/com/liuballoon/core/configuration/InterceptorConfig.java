package com.liuballoon.core.configuration;

import com.liuballoon.core.auth.PermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 获取权限校验器实例
     *
     * @return 权限校验器
     */
    @Bean
    public PermissionInterceptor getPermissionInstance() {
        return new PermissionInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getPermissionInstance());
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
