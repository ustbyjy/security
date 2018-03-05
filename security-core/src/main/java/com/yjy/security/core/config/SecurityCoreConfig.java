package com.yjy.security.core.config;

import com.yjy.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {SecurityProperties.class})
public class SecurityCoreConfig {
}
