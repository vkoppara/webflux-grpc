package com.vk.webflux.grpc.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;

@Slf4j
@GRpcGlobalInterceptor
public class GrpcServerRequestInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        metadata.get(Metadata.Key.of("Test-Header", Metadata.ASCII_STRING_MARSHALLER));
        return serverCallHandler.startCall(serverCall, metadata);
    }
}
