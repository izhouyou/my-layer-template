package com.youzi.layer.web;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @title MySubcontractTemplateApplication
 * @description 启动类
 * @author izhouy
 * @dateTime 2022/10/14 10:08
 * @editNote
 */
@SpringBootApplication(scanBasePackages = "com.youzi.layer")
@RetrofitScan("com.youzi.layer.rpc.service")
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
