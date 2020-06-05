package com.pt.ptuser;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.pt"})
public class PtUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtUserApplication.class, args);
    }

}
