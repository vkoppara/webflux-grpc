package com.vk.webflux.grpc.controller.rest;

import com.vk.webflux.grpc.TestRequest;
import com.vk.webflux.grpc.dto.TestRequestDto;
import com.vk.webflux.grpc.dto.TestResponseDto;
import com.vk.webflux.grpc.service.TestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TestRestController {

    @Autowired
    private TestClientService testClientService;

    @PostMapping("/testService/mono")
    public Mono<TestResponseDto> testMono(@RequestBody TestRequestDto testRequestDto){
        return testClientService.testMono(testRequestDto);
    }

    @PostMapping("/testService/flux")
    public Flux<TestResponseDto> testFlux(@RequestBody TestRequestDto testRequestDto){
        return testClientService.testFlux(testRequestDto);
    }


}
