package org.example.app;

public class Alien {

    public Computer computer;
    public Alien(){
        System.out.println("Alien constructor initiated");
    }

    public Alien(Computer computer){
        this.computer=computer;
    }

//    public void setComputer(Computer computer){
//        this.computer = computer;
//    }

    public void build(){
        computer.compile();
        System.out.println("Building");
    }
}
