package com.vk.webflux.grpc.builder;

import com.vk.webflux.grpc.interceptor.GrpcClientRequestInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.micrometer.core.instrument.binder.grpc.ObservationGrpcClientInterceptor;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientChannelBuilder {

    @Autowired
    public GrpcClientRequestInterceptor grpcClientRequestInterceptor;

    @Autowired
    public ObservationRegistry observationRegistry;

    public ManagedChannel forTarget(String target){
        return ManagedChannelBuilder.forTarget(target).intercept(grpcClientRequestInterceptor,
                new ObservationGrpcClientInterceptor(observationRegistry))
                .usePlaintext().build();
    }
}
