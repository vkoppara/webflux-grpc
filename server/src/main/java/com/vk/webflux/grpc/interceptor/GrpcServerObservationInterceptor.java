package com.vk.webflux.grpc.interceptor;

import io.micrometer.core.instrument.binder.grpc.ObservationGrpcServerInterceptor;
import io.micrometer.observation.ObservationRegistry;

import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerObservationInterceptor {

    @Autowired
    private ObservationRegistry observationRegistry;

    @Bean
    @GRpcGlobalInterceptor
    public ObservationGrpcServerInterceptor interceptor(ObservationRegistry observationRegistry){
        return new ObservationGrpcServerInterceptor(observationRegistry);
    }
}
