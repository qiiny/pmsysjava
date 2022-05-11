package com.qiin.pmsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Qin
 * @Date: 2022/2/22.
 */
@SpringBootApplication
@MapperScan("com.qiin.pmsys.dao")
public class PMSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(PMSysApplication.class, args);

    }
}
