package com.ccz.curso.springboot_di.service;

import com.ccz.curso.springboot_di.model.ProductModel;

import java.util.List;

public interface InterfaceProductService {

    public List<ProductModel> findAll();

    public ProductModel findById(Long id);

}
