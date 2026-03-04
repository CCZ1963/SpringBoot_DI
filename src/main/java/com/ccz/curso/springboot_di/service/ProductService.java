package com.ccz.curso.springboot_di.service;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// @Component
// Lo reemplazamos con @Service
@Service
public class ProductService implements InterfaceProductService {

    // private ProductRepository repository = new ProductRepository();
    // La línea de arriba es reemplazada por las dos líneas siguientes
    // @Autowired -> ahora anulamos @Autowired y creamos el constructor
    // Tenemos el mismo resultado, otra forma de realizar Inyección de Dependencia
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            ProductModel newProductModel = (ProductModel) p.clone();
            newProductModel.setPrice(p.getPrice().longValue());
            return newProductModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductModel findById(Long id){
        return productRepository.findById(id);
    }
}
