package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
@Entity
public class Product {

    @Id
    private int productId;
    private String productName;
    private int productPrice;

    public Product(){

    }
}
