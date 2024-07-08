package com.vk.webflux.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcWebFluxServerApp {
    public static void main(String[] args) {
        SpringApplication.run(GrpcWebFluxServerApp.class, args);
    }
}