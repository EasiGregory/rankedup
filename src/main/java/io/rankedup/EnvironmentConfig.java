package io.rankedup;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "environment")
public class EnvironmentConfig {
    private String url;
    private String name;
}
