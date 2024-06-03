package org.marre.webapplication;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        log.info("=====================COMPELETE============================");
    }

}
