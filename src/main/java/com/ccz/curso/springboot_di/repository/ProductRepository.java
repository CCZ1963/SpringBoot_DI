package com.ccz.curso.springboot_di.repository;

import com.ccz.curso.springboot_di.model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    // Una lista del tipo Product
    private List<Product> data;

    public ProductRepository(List<Product> data) {
        this.data = Arrays.asList(
                new Product(1L, "Memoria Corsair 32", 300L),
                new Product(2L, "CPU Intel Core 19", 850L),
                new Product(3L, "Teclado Razer5 Mini 60", 180L),
                new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return data;
    }
}
