package com.hot.commonUtils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jin
 * @date 2021/8/13
 */
@SpringBootApplication
@EnableEurekaServer
public class StarterEureka extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StarterEureka.class,args);
    }
}
