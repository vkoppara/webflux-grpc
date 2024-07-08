package com.vk.webflux.grpc.interceptor;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GrpcClientRequestInterceptor implements ClientInterceptor {


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
                channel.newCall(methodDescriptor,callOptions)
        ) {
            @Override
            public void start(ClientCall.Listener<RespT> respTListener, Metadata headers){
                headers.put(Metadata.Key.of("Test-Header", Metadata.ASCII_STRING_MARSHALLER), "test-header-value");
                super.start(respTListener, headers);
            }
        };

    }
}
