package com.vk.webflux.grpc.client;

import com.vk.webflux.grpc.ReactorTestServiceGrpc;
import com.vk.webflux.grpc.TestRequest;
import com.vk.webflux.grpc.TestResponse;
import com.vk.webflux.grpc.builder.ClientChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TestClient {

    private ReactorTestServiceGrpc.ReactorTestServiceStub stub;

    @Autowired
    public TestClient(ClientChannelBuilder clientChannelBuilder,
                      @Value("${grpc.client.server.address}") String target){
        stub = ReactorTestServiceGrpc.newReactorStub(clientChannelBuilder.forTarget(target));
    }

    public Mono<TestResponse> testMono(Mono<TestRequest> testRequestMono){
        return stub.testMono(testRequestMono);
    }

    public Flux<TestResponse> testFlux(Mono<TestRequest> testRequestFlux){
        return stub.testFlux(testRequestFlux);
    }

}
