package com.example.SpringSecurityProject;

import com.example.SpringSecurityProject.Model.Product;
import com.example.SpringSecurityProject.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    ProductService service;

    @GetMapping("/")
    public String greet(){
        return "hello,worlddd";
    }

    @GetMapping("/session")
    public CsrfToken getSessionId(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return service.getProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

}
