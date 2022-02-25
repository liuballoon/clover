package com.liuballoon.core.auth;

import com.auth0.jwt.interfaces.Claim;
import com.liuballoon.common.enums.SelectBy;
import com.liuballoon.core.exception.http.ForbiddenException;
import com.liuballoon.core.exception.http.UnauthorizedException;
import com.liuballoon.model.UserDO;
import com.liuballoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 权限校验器
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

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
        Map<String, Claim> claims = this.jwtBuilder.getClaims(token);
        this.checkPermission(accessScope, claims.get("userLevel").asInt());
        this.saveLocalUser(claims.get("userId").asString());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUser.clear();
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

    /**
     * 校验权限
     *
     * @param access 权限注解
     * @param userLevel 用户等级
     */
    private void checkPermission(AccessScope access, Integer userLevel) {
        if (access.value().getValue() > userLevel) {
            throw new ForbiddenException(70010);
        }
    }

    /**
     * 保存用户
     *
     * @param userId 用户主键
     */
    private void saveLocalUser(String userId) {
        UserDO user = this.userService.getUserByCondition(userId, SelectBy.ID);
        LocalUser.set(user);
    }
}
