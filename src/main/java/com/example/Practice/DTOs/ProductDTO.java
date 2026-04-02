package com.example.Practice.DTOs;


import com.example.Practice.Models.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ProductDTO {

    public String name;
    public String description;
    public CategoryDTO category;
    public LocalDateTime createdDateTime;
    public LocalDateTime updatedDateTime;

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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
