package com.example.Practice.DTOs;

import java.util.List;

public class CategoryDTO {
    public String name;
    public String description;
//    public List<ProductDTO> products;

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

//    public List<ProductDTO> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<ProductDTO> products) {
//        this.products = products;
//    }
}
