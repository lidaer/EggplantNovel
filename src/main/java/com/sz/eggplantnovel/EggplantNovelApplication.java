package com.sz.eggplantnovel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author sz
 */
@EnableCaching
@EnableConfigurationProperties
@MapperScan("com.sz.eggplantnovel.dao.mapper")
public class EggplantNovelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggplantNovelApplication.class, args);
    }

}
