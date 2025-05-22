package ru.t1.javapro.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.t1.javapro.handler.RestTemplateResponseErrorHandler;

@Configuration
@EnableConfigurationProperties(UserProductProperties.class)
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserProductProperties userProductProperties;

    @Bean
    public RestTemplate userProduct(RestTemplateResponseErrorHandler errorHandler) {
        RestTemplateProperties restTemplateProperties = userProductProperties.getUserProduct();
        return new RestTemplateBuilder()
                .rootUri(restTemplateProperties.getUrl())
                .readTimeout(restTemplateProperties.getReadTimeout())
                .connectTimeout(restTemplateProperties.getConnectTimeout())
                .errorHandler(errorHandler)
                .build();
    }
}
