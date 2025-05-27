package ru.t1.javapro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "integration")
public class UserProductProperties {

    private final RestTemplateProperties restTemplateProperties;

    @ConstructorBinding
    public UserProductProperties(RestTemplateProperties userProduct) {
        this.restTemplateProperties = userProduct;
    }

    public RestTemplateProperties getRestTemplateProperties() {

        return restTemplateProperties;
    }
}
