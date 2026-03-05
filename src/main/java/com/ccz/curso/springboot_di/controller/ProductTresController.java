package com.ccz.curso.springboot_di.controller;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.service.ProductService;
import com.ccz.curso.springboot_di.service.ProductTresService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api3")
public class ProductTresController {

    // private ProductService productService = new ProductService();
    // La línea de arriba se reemplaza con las dos siguientes
    // @Autowired -> Ahora anulamos @Autowired y creamos el constructor
    // Tenemos el mismo resultado, otra forma de realizar Inyección de Dependencia
    private ProductTresService productTresService;

    public ProductTresController(ProductTresService productTresService) {
        this.productTresService = productTresService;
    }

    @GetMapping
    public List<ProductModel> list() {
        return productTresService.findAll();
    }

    @GetMapping("/{id}")
    public ProductModel show(@PathVariable Long id){
        return productTresService.findById(id);
    }
}
