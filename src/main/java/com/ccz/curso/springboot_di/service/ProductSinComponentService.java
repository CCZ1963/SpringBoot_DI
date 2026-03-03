package com.ccz.curso.springboot_di.service;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductSinComponentService implements InterfaceProductService {

    private ProductRepository repository = new ProductRepository();

    @Override
    public List<ProductModel> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            ProductModel newProductModel = (ProductModel) p.clone();
            newProductModel.setPrice(p.getPrice().longValue());
            return newProductModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductModel findById(Long id){
        return repository.findById(id);
    }
}
