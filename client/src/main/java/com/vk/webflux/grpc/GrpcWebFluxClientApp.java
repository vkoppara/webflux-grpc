package com.vk.webflux.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcWebFluxClientApp {
    public static void main(String[] args) {
        SpringApplication.run(GrpcWebFluxClientApp.class, args);
    }
}