package com.megvii.lbg.synchronizer;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.megvii.lbg.synchronizer.mapper")
class EsSynchronizerApplicationTests {

    @Test
    void contextLoads() {
    }

}
