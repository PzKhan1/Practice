package com.example.Practice.Services;

import com.example.Practice.Models.Category;
import com.example.Practice.Models.Product;
import com.example.Practice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductServiceIMPL implements ProductServiceInterface{


ProductRepository productRepository;



public ProductServiceIMPL(ProductRepository pr){
    this.productRepository = pr;
}
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll() ;
    }

    public Product getProductById (UUID uuid){

            Optional<Product> prod = productRepository.findById(uuid);
            if(prod.isEmpty()){
                return null;
            }

            return prod.get();

    }
public List<Product> getProductsByCategoryName(String categoryName){
    List<Product> prods = productRepository.findAllByCategoryNameIgnoreCase(categoryName);
    return prods;
}

public Product createProductByReqParam(String pN , String pD, String cN, String cD ){
    Product pd = new Product();
    Category ct = new Category();
    pd.setName(pN);
    pd.setDescription(pD);
//    pd.getCategory().setName(cN);
//    pd.getCategory().setDesc(cD);
    ct.setName(cN);
    ct.setDesc(cD);
    pd.setCategory(ct);
    pd.setCreatedDateTime(LocalDateTime.now());

    pd = productRepository.save(pd);
    return pd;
}

public Product updateProduct(Product prod , UUID uuid){


    Optional<Product> product = productRepository.findById(uuid);
    if(product.isPresent()){
        Category cat = new Category();
        product.get().setName(prod.getName());
        product.get().setDescription(prod.getDescription());
        cat.setName(prod.getCategory().getName());
        cat.setDesc(prod.getCategory().getDesc());
        product.get().setCategory(cat);
        productRepository.save(product.get());
        return product.get();
    }



    return prod;
}


public String deleteProduct(UUID uuid){

     productRepository.deleteById(uuid);

     return "Product with id"  + uuid  + "is deleted";
}


}
