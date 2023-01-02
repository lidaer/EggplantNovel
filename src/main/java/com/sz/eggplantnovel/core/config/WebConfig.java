package com.sz.eggplantnovel.core.config;

import com.sz.eggplantnovel.core.common.constant.ApiRouterConsts;
import com.sz.eggplantnovel.core.constant.SystemConfigConsts;
import com.sz.eggplantnovel.core.interceptor.AuthInterceptor;
import com.sz.eggplantnovel.core.interceptor.FlowLimitInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sz
 * @version 1.0
 * @date 2023/1/2
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final FlowLimitInterceptor flowLimitInterceptor;

    private final AuthInterceptor authInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 流量限制拦截器
        registry.addInterceptor(flowLimitInterceptor)
                .addPathPatterns("/**")
                .order(0);


        // 权限认证拦截
        registry.addInterceptor(authInterceptor)
                // 拦截会员中心相关请求接口
                .addPathPatterns(ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/**",
                        // 拦截作家后台相关请求接口
                        ApiRouterConsts.API_AUTHOR_URL_PREFIX + "/**",
                        // 拦截平台后台相关请求接口
                        ApiRouterConsts.API_ADMIN_URL_PREFIX + "/**")
                // 放行登录注册相关请求接口
                .excludePathPatterns(ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/register",
                        ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/login",
                        ApiRouterConsts.API_ADMIN_URL_PREFIX + "/login")
                .order(2);
    }
}
