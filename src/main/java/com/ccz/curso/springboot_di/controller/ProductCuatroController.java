package com.ccz.curso.springboot_di.controller;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.ccz.curso.springboot_di.service.ProductCuatroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api4")
public class ProductCuatroController {

    // private ProductService productService = new ProductService();
    // La línea de arriba se reemplaza con las dos siguientes
    // @Autowired -> Ahora anulamos @Autowired y creamos el constructor
    // Tenemos el mismo resultado, otra forma de realizar Inyección de Dependencia
    private ProductCuatroService productCuatroService;

    public ProductCuatroController(ProductCuatroService productCuatroService) {
        this.productCuatroService = productCuatroService;
    }

    @GetMapping
    public List<ProductModel> list() {
        return productCuatroService.findAll();
    }

    @GetMapping("/{id}")
    public ProductModel show(@PathVariable Long id){
        return productCuatroService.findById(id);
    }
}
