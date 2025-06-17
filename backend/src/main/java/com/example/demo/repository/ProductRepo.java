package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query("select p from Product p " +
            "where LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    public List<Product> searchByKeyword(String keyword);
}
