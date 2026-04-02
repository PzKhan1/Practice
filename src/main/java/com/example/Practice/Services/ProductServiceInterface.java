package com.example.Practice.Services;

import com.example.Practice.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface ProductServiceInterface {

    public List<Product> getAllProducts();
    public Product getProductById(UUID uuid);
    public List<Product> getProductsByCategoryName(String name);
    public Product createProductByReqParam(String pN , String pD, String cN, String cD  );
    public Product updateProduct(Product product , UUID uuid);
    public String deleteProduct(UUID uuid);
}
