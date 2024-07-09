package com.vk.webflux.grpc.service;

import com.vk.webflux.grpc.TestRequest;
import com.vk.webflux.grpc.TestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TestService {

    public Mono<TestResponse> testMono(Mono<TestRequest> testRequest) {
        return testRequest.map(k -> TestResponse.newBuilder().setName(k.getName())
                .setValue(k.getValue())
                .setId(UUID.randomUUID().toString())
                .build()).log();
    }

    public Flux<TestResponse> testFlux(Mono<TestRequest> testRequest) {
        return testRequest.map(k -> List.of(TestResponse.newBuilder().setName(k.getName())
                .setValue(k.getValue())
                .setId(UUID.randomUUID().toString())
                .build())).flatMapIterable(k-> k).log();
    }
}
