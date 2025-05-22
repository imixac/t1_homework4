package ru.t1.dto;

import ru.t1.entity.Product;

import java.util.Set;

public record UserProductsDTO(Long id, String username, Set<Product> products) {
}
