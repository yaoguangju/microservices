package com.mochen.auth.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
public class JwtConfig {
    @Value("${customize.jwt.secret}")
    private String jwtSecret;
}
