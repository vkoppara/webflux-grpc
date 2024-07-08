package com.vk.webflux.grpc.controller.grpc;

import com.vk.webflux.grpc.ReactorTestServiceGrpc;
import com.vk.webflux.grpc.TestRequest;
import com.vk.webflux.grpc.TestResponse;
import com.vk.webflux.grpc.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@GRpcService
@Slf4j
public class TestController extends ReactorTestServiceGrpc.TestServiceImplBase{

    @Autowired
    private TestService testService;

    @Override
    public Mono<TestResponse> testMono(Mono<TestRequest> testRequest){
        return testService.testMono(testRequest);
    }

    @Override
    public Flux<TestResponse> testFlux(Mono<TestRequest> testRequest){
        return testService.testFlux(testRequest);
    }
}
