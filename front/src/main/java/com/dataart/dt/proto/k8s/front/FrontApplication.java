package com.dataart.dt.proto.k8s.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FrontApplication {

    static private Logger log = LoggerFactory.getLogger(FrontApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

}
