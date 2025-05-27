package ru.t1.javapro.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.t1.javapro.dto.UserProductErrorResponse;
import ru.t1.javapro.exceptions.IntegrationException;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private final ObjectMapper mapper;

    public RestTemplateResponseErrorHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();
        return statusCode.is4xxClientError() || statusCode.is5xxServerError();
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            UserProductErrorResponse userProductErrorResponse =
                    mapper.readValue(response.getBody(), UserProductErrorResponse.class);

            throw new IntegrationException(userProductErrorResponse.toString(), response.getStatusText());
        }
    }
}
