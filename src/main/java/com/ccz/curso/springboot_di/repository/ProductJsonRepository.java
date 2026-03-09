package com.ccz.curso.springboot_di.repository;

import com.ccz.curso.springboot_di.model.ProductModel;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
// Borrar luego

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductJsonRepository implements InterfaceProductRepository{

    public List<ProductModel> listJson;

    public ProductJsonRepository() {
        ClassPathResource resource = new ClassPathResource("json/products.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            listJson = Arrays.asList(objectMapper.readValue(resource.getFile(), ProductModel[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    @Override
    public List<ProductModel> findAll() {
        return listJson;
    }

    @Override
    public ProductModel findById(Long id) {
        return null;
    }
}
