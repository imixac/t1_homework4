package ru.t1.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.t1.dto.ProductDTO;
import ru.t1.dto.ProductsDTO;
import ru.t1.entity.Product;
import ru.t1.repository.ProductRepository;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found: " + id));
        return new ProductDTO(product.getId(), product.getAccountNumber(), product.getBalance(), product.getProductType());
    }

    public Set<Product> getAllProductsById(Long id) {
        return productRepository.findByUserId(id);
    }

    public ProductsDTO getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ProductsDTO(products, products.size());
    }

    @Transactional
    public void updateProduct(ProductDTO productDTO) {
        productRepository.updateBalance(productDTO.id(), Float.parseFloat(productDTO.balance()));
    }

}
