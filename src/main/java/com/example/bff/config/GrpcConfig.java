package com.example.bff.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({GrpcClientAutoConfiguration.class})
public class GrpcConfig {
}
