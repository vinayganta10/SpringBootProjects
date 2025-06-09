package com.example.SpringSecurityProject.Service;

import com.example.SpringSecurityProject.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    public ResponseEntity<Product> addProduct(Product product) {
        products.add(product);
        return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
    }
}
