package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by jingxingqiang on 2019/12/20 23:15
 */
@SpringBootApplication
@EnableEurekaServer  // 启动eureka服务端
public class LegouRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LegouRegistryApplication.class,args);
    }
}
