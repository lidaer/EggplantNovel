package com.sz.eggplantnovel.core.auth;

import com.sz.eggplantnovel.core.common.exception.BusinessException;
import com.sz.eggplantnovel.core.util.JwtUtils;
import com.sz.eggplantnovel.manager.Cache.UserInfoCacheManager;
import jdk.jfr.Registered;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 前台门户系统 认证授权策略
 *
 * @author sz
 * @version 1.0
 * @date 2022/12/31
 */
@RequiredArgsConstructor
@Component
public class FrontAuthStrategy implements AuthStrategy {
    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;

    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        // 统一账号认证
        authSSO(jwtUtils, userInfoCacheManager, token);
    }

}
