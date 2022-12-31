package com.sz.eggplantnovel.core.auth;

import com.sz.eggplantnovel.core.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 平台后台管理系统 认证授权策略
 *
 * @author sz
 * @version 1.0
 * @date 2022/12/31
 */

@Component
@RequiredArgsConstructor
public class AdminAuthStrategy implements AuthStrategy{
    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        // TODO 平台后台 token 校验 (还未写平台后台管理系统)
    }
}
