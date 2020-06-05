package com.pt.ptcenteruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.pt"})
public class PtCenterUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtCenterUserApplication.class, args);
    }

}
