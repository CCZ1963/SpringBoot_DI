package com.ccz.curso.springboot_di.repository;

import com.ccz.curso.springboot_di.model.ProductModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

@SessionScope
// @Component
// Lo reemplazamos con @Repository
// @Repository Es un Component con acceso a datos, más específico
@Repository("productListCuatro") // Le damos el seudónimo de producttList a productRepository
public class ProductCuatroRepository implements InterfaceProductRepository {

    // Una lista del tipo Product
    private List<ProductModel> data;

    public ProductCuatroRepository() {
        this.data = Arrays.asList(
                new ProductModel(1L, "Monitor Lenovo 32", 700L),
                new ProductModel(2L, "Memoria RAM 8GB", 525L),
                new ProductModel(3L, "Mouse Ergonométrico Ergo", 90L),
                new ProductModel(4L, "Motherboard Enterprice", 120L),
                new ProductModel(5L, "Camara Gestor MCX", 430L)
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
