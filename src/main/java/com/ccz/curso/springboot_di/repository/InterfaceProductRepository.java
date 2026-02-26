package com.ccz.curso.springboot_di.repository;

import com.ccz.curso.springboot_di.model.ProductModel;

import java.util.List;

public interface InterfaceProductRepository {

    List<ProductModel> findAll();

    ProductModel findById(Long id);
}
