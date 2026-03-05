package com.ccz.curso.springboot_di.repository;

import com.ccz.curso.springboot_di.model.ProductModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Primary // Tenemos dos tipos de Repository y esta orden elige cual es la válida
@Repository
public class ProductFooRepository implements InterfaceProductRepository {

    @Override
    public List<ProductModel> findAll() {
        return Collections.singletonList(new ProductModel(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public ProductModel findById(Long id) {
        return new ProductModel(1L, "Monitor Asus 27", 600L);
    }
}
