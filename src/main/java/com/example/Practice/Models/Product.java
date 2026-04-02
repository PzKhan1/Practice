package com.example.Practice.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor

public class Product extends BaseClass {

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    public UUID productId;

    public String name;
    public String description;
    @ManyToOne(cascade = CascadeType.ALL)
    public Category category;
    private Double price;

//    public UUID getProductId() {
//        return productId;
//    }

//    public void setProductId(UUID productId) {
//        this.productId = productId;
//    }


    public Product(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;

    }

    public Product(String name, String description, Category category, Double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
