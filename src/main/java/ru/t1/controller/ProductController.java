package ru.t1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.t1.dto.ProductDTO;
import ru.t1.entity.Product;
import ru.t1.service.ProductService;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ProductDTO(product.getId(), product.getAccountNumber(), product.getBalance(), product.getProductType());
    }

    @GetMapping("/get-all-product-byuser/{id}")
    public Set<Product> getProductByUserId(@PathVariable Long id) {
        return productService.getAllProductsById(id);
    }
}
