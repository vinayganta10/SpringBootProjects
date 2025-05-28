package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getProductList(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product){
        service.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return "Product deleted";
    }
}
