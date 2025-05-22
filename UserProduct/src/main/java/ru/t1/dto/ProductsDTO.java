package ru.t1.dto;

import ru.t1.entity.Product;

import java.util.List;

public record ProductsDTO(List<Product> products, int count) {
}
