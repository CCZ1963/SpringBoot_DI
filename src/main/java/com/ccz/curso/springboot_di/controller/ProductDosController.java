package com.ccz.curso.springboot_di.controller;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.service.ProductDosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class ProductDosController {

    // private ProductService productService = new ProductService();
    // La línea de arriba se reemplaza con las dos siguientes
    // @Autowired -> Ahora anulamos @Autowired y creamos el constructor
    // Tenemos el mismo resultado, otra forma de realizar Inyección de Dependencia
    private ProductDosService productDosService;

    public ProductDosController(ProductDosService productService) {
        this.productDosService = productService;
    }

    @GetMapping
    public List<ProductModel> list() {
        return productDosService.findAll();
    }

    @GetMapping("/{id}")
    public ProductModel show(@PathVariable Long id){
        return productDosService.findById(id);
    }
}
