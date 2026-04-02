package com.example.Practice.Repositories;

import com.example.Practice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository< Product, UUID> {

    public List<Product> findAllByCategoryNameIgnoreCase(String name);

}
