package org.example.app;

public class Laptop implements Computer{
    public Laptop(){
        System.out.println("Laptop constructor");
    }

    public void compile(){
        System.out.println("Compiled");
    }
}
