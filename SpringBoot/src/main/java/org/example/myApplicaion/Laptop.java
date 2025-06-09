package org.example.myApplicaion;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer {
    public Laptop(){
        System.out.println("laptop initiated");
    }
    @Override
    public void compile(){
        System.out.println("Compiled using laptop");
    }
}
