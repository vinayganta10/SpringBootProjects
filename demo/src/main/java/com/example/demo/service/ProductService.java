package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> productList= Arrays.asList(new Product(101,"OnePlus 12R",30000),new Product(102,"OnePlus NORD CE3",28000),new Product(103,"SAMSUNG S20",40000));

    public List<Product> getProductList(){
        return productList;
    }
}
