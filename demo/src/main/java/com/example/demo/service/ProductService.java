package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> productList= new ArrayList<>(Arrays.asList(new Product(101,"OnePlus 12R",30000),new Product(102,"OnePlus NORD CE3",28000),new Product(103,"SAMSUNG S20",40000)));

    public List<Product> getProductList(){
        return productList;
    }

    public Product getProductById(int id) {
        return productList.stream()
                .filter(p->p.getProductId()==id)
                .findFirst()
                .orElse(new Product(0,"NO ITEM",0));
    }


    public void addProduct(Product product) {
        productList.add(product);
    }


    public void updateProduct(Product product) {
        int idx = -1;
        for(int i=0;i<productList.size();i++){
            if(product.getProductId()==productList.get(i).getProductId()){
                idx=i;
                break;
            }
        }
        productList.set(idx,product);
    }

    public void deleteProduct(int id) {
        int idx = -1;
        for(int i=0;i<productList.size();i++){
            if(id==productList.get(i).getProductId()){
                idx=i;
                break;
            }
        }
        productList.remove(idx);
    }
}
