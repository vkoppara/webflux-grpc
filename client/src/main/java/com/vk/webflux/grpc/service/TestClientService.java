package com.vk.webflux.grpc.service;

import com.vk.webflux.grpc.client.TestClient;
import com.vk.webflux.grpc.dto.TestRequestDto;
import com.vk.webflux.grpc.dto.TestResponseDto;
import com.vk.webflux.grpc.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TestClientService {

    @Autowired
    private TestClient testClient;

    @Autowired
    private TestMapper testMapper;

    public Mono<TestResponseDto> testMono(TestRequestDto testRequestDto) {
        return testClient.testMono(Mono.just(testMapper.fromDtoToProto(testRequestDto))).map(k -> testMapper.fromProtoToDto(k));
    }

    public Flux<TestResponseDto> testFlux(TestRequestDto testRequestDto) {
        return testClient.testFlux(Mono.just(testMapper.fromDtoToProto(testRequestDto))).map(k -> testMapper.fromProtoToDto(k));
    }
}
