package com.megvii.lbg.synchronizer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.megvii.lbg.synchronizer.mapper")
public class EsSynchronizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsSynchronizerApplication.class, args);
    }

}
