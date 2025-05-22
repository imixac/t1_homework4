package ru.t1.javapro.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "integration")
public class UserProductProperties {

    private final RestTemplateProperties userProduct;

    @ConstructorBinding
    public UserProductProperties(RestTemplateProperties userProduct) {
        this.userProduct = userProduct;
    }

    public RestTemplateProperties getUserProduct() {

        return userProduct;
    }
}
