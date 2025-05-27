package ru.t1.javapro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.t1.javapro.dto.*;
import ru.t1.javapro.service.PaymentsService;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/integration")
public class PaymentController {

    private final PaymentsService paymentsService;

    @GetMapping("/health")
    public ResponseMessage health() {
        return new ResponseMessage("Сервис Работает");
    }

    @GetMapping("/user/{id}")
    public PaymentResponse getUser(@PathVariable Long id) {
        UserDTO user = paymentsService.callGetUser(id);
        return new PaymentResponse("Найден пользователь", Objects.requireNonNull(user).toString());
    }

    @GetMapping("/product/{id}")
    public PaymentResponse getProduct(@PathVariable Long id) {
        ProductDTO product = paymentsService.callGetProduct(id);
        return new PaymentResponse("Найден продукт", Objects.requireNonNull(product).toString());
    }

    @GetMapping("/user-product/{id}")
    public PaymentResponse getProductsByUser(@PathVariable Long id) {
        ProductDTO product = paymentsService.callGetProductByUser(id);
        return new PaymentResponse("Найден продукт", Objects.requireNonNull(product).toString());
    }

    @PostMapping("/pay")
    public boolean pay(@RequestBody PayDTO payDTO) {
        return paymentsService.payWithIdAndSum(payDTO);
    }

}
