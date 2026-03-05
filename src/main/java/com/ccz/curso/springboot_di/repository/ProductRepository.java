package com.ccz.curso.springboot_di.repository;

import com.ccz.curso.springboot_di.model.ProductModel;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Arrays;
import java.util.List;

@RequestScope
// @Component
// Lo reemplazamos con @Repository
// @Repository Es un Component con acceso a datos, más específico
@Repository("productList") // Le damos el seudónimo de producttList a productRepository
public class ProductRepository implements InterfaceProductRepository {

    // Una lista del tipo Product
    private List<ProductModel> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new ProductModel(1L, "Memoria Corsair 32", 300L),
                new ProductModel(2L, "CPU Intel Core 19", 850L),
                new ProductModel(3L, "Teclado Razer5 Mini 60", 180L),
                new ProductModel(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<ProductModel> findAll(){
        return data;
    }

    @Override
    public ProductModel findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
