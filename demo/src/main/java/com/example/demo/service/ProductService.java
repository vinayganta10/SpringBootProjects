package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    //private List<Product> productList= new ArrayList<>(Arrays.asList(new Product(101,"OnePlus 12R",30000),new Product(102,"OnePlus NORD CE3",28000),new Product(103,"SAMSUNG S20",40000)));

    @Autowired
    ProductRepo repo;

    public List<Product> getProductList(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product(0,"No item",0));
    }


    public void addProduct(Product product) {
        repo.save(product);
    }


    public void updateProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
