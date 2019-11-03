package com.jiutian.jiutian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.jiutian.jiutian.mapper")
@EnableSwagger2
public class JiutianApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiutianApplication.class, args);
    }

}
