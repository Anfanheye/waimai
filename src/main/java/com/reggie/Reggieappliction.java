package com.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 类描述：
 *
 * @ClassName Reggieappliction
 * @Description TODO
 * @Author Ming
 * @Date 2022/7/18 14:40
 * @Version 1.0
 */

@SpringBootApplication
@Slf4j
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching //开启Spring Cache注解方式的缓存功能
public class Reggieappliction {
    public static void main(String[] args) {
        SpringApplication.run(Reggieappliction.class,args);
        log.info("项目启动成功...");
    }
}
