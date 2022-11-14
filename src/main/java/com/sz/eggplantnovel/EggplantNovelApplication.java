package com.sz.eggplantnovel;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Map;

/**
 * @author sz
 */
@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
@MapperScan("com.sz.eggplantnovel.dao.mapper")
@EnableScheduling
@Slf4j
public class EggplantNovelApplication {

    public static void main(String[] args) {

        SpringApplication.run(EggplantNovelApplication.class, args);

/*        try {
            SpringApplication.run(EggplantNovelApplication.class, args);
        }catch(Exception e) {
            e.printStackTrace();
        }*/
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            Map<String, CacheManager> beans = context.getBeansOfType(CacheManager.class);
            log.info("加载了如下缓存管理器：");
            beans.forEach((k, v) -> {
                log.info("{}:{}", k, v.getClass().getName());
                log.info("缓存：{}", v.getCacheNames());
            });

        };
    }

}
