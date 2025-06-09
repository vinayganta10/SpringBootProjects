package org.example.myApplicaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    @Qualifier("desktop")
    Computer comp;

    public Alien(){
        System.out.println("alien initiated");
    }

//    @Autowired
//    public void setup(Laptop laptop){
//        this.laptop=laptop;
//    }
    public void build(){
        comp.compile();
        System.out.println("Building application");
    }
}
