package com.vk.webflux.grpc.mapper;

import com.vk.webflux.grpc.TestRequest;
import com.vk.webflux.grpc.TestResponse;
import com.vk.webflux.grpc.dto.TestRequestDto;
import com.vk.webflux.grpc.dto.TestResponseDto;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestMapper {

    TestRequest fromDtoToProto (TestRequestDto testRequestDto);
    TestResponseDto fromProtoToDto (TestResponse testResponse);

    default UUID map(String value){
        if(value == null || value.isEmpty() || value.isBlank()){
            return null;
        } else {
            return UUID.fromString(value);
        }
    }
}
