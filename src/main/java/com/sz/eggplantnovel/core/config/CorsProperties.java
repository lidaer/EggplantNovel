package com.sz.eggplantnovel.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 跨域配置属性
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/11
 */
@ConfigurationProperties(prefix = "novel.cors")
@Data
public class CorsProperties {
    /**
     * 允许跨域的域名
     * */
    private List<String> allowOrigins;
}
