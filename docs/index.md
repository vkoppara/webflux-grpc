# This is a WebFlux and GRPC - hello world program (Spring version - 3.3.1)
Used the following dependencies
```
            <dependency>
                <groupId>io.grpc</groupId>
                <artifactId>grpc-protobuf</artifactId>
                <version>1.58.0</version>
            </dependency>
            <dependency>
                <groupId>io.grpc</groupId>
                <artifactId>grpc-stub</artifactId>
                <version>1.58.0</version>
            </dependency>
            <dependency>
                <groupId>com.google.protobuf</groupId>
                <artifactId>protobuf-java</artifactId>
                <version>3.22.3</version>
            </dependency>
            <dependency>
                <groupId>com.salesforce.servicelibs</groupId>
                <artifactId>reactor-grpc-stub</artifactId>
                <version>1.2.4</version>
            </dependency>
```
It contains server, client, and proto modules, demonstrates
1) How Grpc Intercepeptors (both client and server) can be configured
2) Observablity - logger traceId etc can be passed with the help of micrometer(It is not fully implemented)
3) How ManagedChannel can be created and used. (Single Channel is used for all, however it creates a problem during load run, requests may be messed up due to webflux. Thinking for a solution)
4) Mapstruct is used to transulate dtos to protos

To - be done:
1) implement a backend database integration (webflux supported db)
2) Caching - Apache Ignite - CDC (using Apsectj)
3) Fully Implement Logging and tracing
4) graphql with grpc
5) Exception handling around GRPC exchange

6) To build docker image locally - mvn clean install jib:dockerBuild
