package com.ccz.curso.springboot_di.controller;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api1")
public class ProductSinComponentController {

    private ProductService productService = new ProductService();

    @GetMapping
    public List<ProductModel> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductModel show(@PathVariable Long id){
        return productService.findById(id);
    }
}
