package com.tech.legou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by jingxingqiang on 2019/12/22 19:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LegouItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LegouItemApplication.class,args);
    }
}
