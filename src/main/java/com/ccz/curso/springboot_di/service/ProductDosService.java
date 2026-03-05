package com.ccz.curso.springboot_di.service;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.repository.InterfaceProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// @Component
// Lo reemplazamos con @Service
@Service
public class ProductDosService implements InterfaceProductService {

    // private ProductRepository repository = new ProductRepository();
    // La línea de arriba es reemplazada por las dos líneas siguientes
    // @Autowired -> ahora anulamos @Autowired y creamos el constructor
    // Tenemos el mismo resultado, otra forma de realizar Inyección de Dependencia

    // Se cambió de ProductRepósitory a InterfaceProductRepository
    private InterfaceProductRepository interfaceProductRepository;

    // Con @Repository("productList") en ProductRepository.java le dimos un seudónimo a ProductRepository
    // También puede ser: public ProductDosService(@Qualifier("productRepository") InterfaceProductRepository interfaceProductRepository)
    public ProductDosService(@Qualifier("productList") InterfaceProductRepository interfaceProductRepository) {
        this.interfaceProductRepository = interfaceProductRepository;
    }

    @Override
    public List<ProductModel> findAll(){
        return interfaceProductRepository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            ProductModel newProductModel = (ProductModel) p.clone();
            newProductModel.setPrice(p.getPrice().longValue());
            return newProductModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductModel findById(Long id){
        return interfaceProductRepository.findById(id);
    }
}
