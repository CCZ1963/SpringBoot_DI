package com.ccz.curso.springboot_di.service;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<ProductModel> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;

            /* Forma anterior, hacia que el objeto en memoria va cambiando,
            se multiplica, cada vez que llamamos a la URL localhost:8080/api,
            por 1.25, incrementando el valor en cada llamada
            p.setPrice(priceImp.longValue());
            return p;
            */
            ProductModel productModel = new ProductModel(p.getId(), p.getName(), priceImp.longValue());
            return productModel;
        }).collect(Collectors.toList());
    }

    public ProductModel findById(Long id){
        return repository.findById(id);
    }
}
