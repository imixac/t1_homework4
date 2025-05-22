package ru.t1.javapro.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.t1.javapro.dto.PaymentResponse;
import ru.t1.javapro.dto.ProductDTO;
import ru.t1.javapro.dto.ResponseMessage;
import ru.t1.javapro.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class PaymentsService {

    private final RestTemplate restTemplate;

    public UserDTO callGetUser(Long id) {
        return restTemplate.getForObject("/user/get/"+id, UserDTO.class);
    }

    public ProductDTO callGetProduct(Long id) {
        return restTemplate.getForObject("/product/get/"+id, ProductDTO.class);
    }

    public ProductDTO callGetProductByUser(Long id) {
        return restTemplate.getForObject("/user/getproduct/"+id, ProductDTO.class);
    }

    public ResponseMessage updateProduct(ProductDTO productDTO) {
        return restTemplate.postForObject("/product/update", productDTO, ResponseMessage.class);
    }
}
