package com.liuballoon.core.auth;

import com.liuballoon.core.exception.http.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限校验器
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTBuilder jwtBuilder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        AccessScope accessScope = this.getAccessScope(handler);
        if (accessScope == null) {
            return true;
        }
        String auth = request.getHeader("Authorization");
        if (!auth.startsWith("Bearer ")) {
            throw new UnauthorizedException(70001);
        }
        String token = auth.substring(7);
        return this.jwtBuilder.verify(token);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 获取控制器的权限注解
     *
     * @param handler 控制器
     * @return 权限注解
     */
    private AccessScope getAccessScope(Object handler) {
        if (handler instanceof HandlerMethod method) {
            return method.getMethodAnnotation(AccessScope.class);
        }
        return null;
    }
}
