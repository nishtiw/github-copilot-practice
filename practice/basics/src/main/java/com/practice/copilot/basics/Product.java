package com.practice.copilot.basics;

//Product class with id, name and quantity
public class Product {
    private int id;
    private String name;
    private int quantity;

    //Constructor
    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //toString method  
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
    }    
}
