package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile) throws IOException {
        Product product1 = service.addProduct(product,imageFile);
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }


    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageFile(@PathVariable int productId){
        Product product = service.getProductById(productId);
        byte[] imageDate = product.getImageDate();
        return ResponseEntity.
                ok().contentType(MediaType.valueOf(product.getImageType()))
                .body(imageDate);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile) throws IOException {
        Product product1 = service.updateProduct(id,product,imageFile);
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        try{
            service.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
