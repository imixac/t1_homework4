package ru.t1.javapro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.t1.javapro.dto.PayDTO;
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

//    public ResponseMessage payWithIdAndSum(PayDTO payDTO) {
//        ProductDTO product = this.callGetProduct(payDTO.id());
//        Float diff = Float.parseFloat(product.balance()) - Float.parseFloat(payDTO.sum());
//        if (diff >= 0) {
//            ProductDTO productDTO = new ProductDTO(product.id(), product.accountNumber(), String.valueOf(diff), product.productType());
//            this.updateProduct(productDTO);
//            return new ResponseMessage("Оплата прошла");
//        }
//        return new ResponseMessage("Не достаточно на балансе");
//    }

    public boolean payWithIdAndSum(PayDTO payDTO) {
        ProductDTO product = this.callGetProduct(payDTO.id());
        Float diff = Float.parseFloat(product.balance()) - Float.parseFloat(payDTO.sum());
        if (diff >= 0) {
            ProductDTO productDTO = new ProductDTO(product.id(), product.accountNumber(), String.valueOf(diff), product.productType());
            this.updateProduct(productDTO);
            return true;
        }
        return false;
    }
}
