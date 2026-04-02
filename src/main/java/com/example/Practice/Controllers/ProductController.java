package com.example.Practice.Controllers;


import com.example.Practice.DTOs.CategoryDTO;
import com.example.Practice.DTOs.ProductDTO;
import com.example.Practice.Models.Category;
import com.example.Practice.Models.Product;
import com.example.Practice.Repositories.ProductRepository;
import com.example.Practice.Services.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {


    public ProductRepository productRepository;
    public ProductServiceIMPL productServiceIMPL;
    public ProductController(ProductRepository pr, ProductServiceIMPL psimpl){
        this.productRepository = pr;
        this.productServiceIMPL = psimpl;
    }


    @GetMapping("/")
    public String homePage(){
        return "Welcome to e commerce";
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllproducts(){
        List<ProductDTO> allProductsDTO = new ArrayList<>();

        List<Product> products =  productServiceIMPL.getAllProducts();
        for(int i = 0 ; i < products.size() ; i++){
            ProductDTO temp = new ProductDTO();
            CategoryDTO tempC = new CategoryDTO();
            temp.setName(products.get(i).getName());
            temp.setDescription(products.get(i).getDescription());
//
            allProductsDTO.add(temp);
        }
        return allProductsDTO;
    }

    @GetMapping("/products/{uuid}")
    public ProductDTO getProductByID(@PathVariable UUID uuid){

        Product product = productServiceIMPL.getProductById(uuid);
        ProductDTO newProd = new ProductDTO();
        CategoryDTO newCat = new CategoryDTO();
        newProd.setName(product.getName());
        newProd.setDescription(product.getDescription());
        newProd.setCreatedDateTime(LocalDateTime.now());
        newCat.setName(product.getCategory().getName());
        newCat.setDescription(product.getCategory().getDesc());
        newProd.setCategory(newCat);


        return newProd;
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product){

        Product newProd = new Product();
        Category newCat = new Category();

//        newProd.setId(UUID.randomUUID());
        newProd.setName(product.getName());
        newProd.setDescription(product.getDescription());
        newProd.setCreatedDateTime(LocalDateTime.now());
        newCat.setName(product.getCategory().getName());
        newCat.setDesc(product.getCategory().getDesc());
        newProd.setCategory(newCat);

        productRepository.save(newProd);

        return newProd;
    }

    @GetMapping("/productsWithCategoryName")
    public List<ProductDTO> getProdsWithCategory(@RequestParam(name = "CategoryName") String Categoryname){
        List<Product> prods = productServiceIMPL.getProductsByCategoryName(Categoryname);
        List<ProductDTO> prodsDTO = new ArrayList<>();
        System.out.println("HEllo");
        for(int i = 0 ; i < prods.size() ; i++){
            ProductDTO temp = new ProductDTO();
            temp.setName(prods.get(i).getName());
            temp.setDescription(prods.get(i).getDescription());

            if (prods.get(i).getCategory() != null) {
                CategoryDTO tempCat = new CategoryDTO();
                tempCat.setName(prods.get(i).getCategory().getName());

                temp.setCategory(tempCat);
            }


            prodsDTO.add(temp);
        }




            return prodsDTO;
    }



    @PostMapping("/Products/Category")
    public ProductDTO createProductwithRequestParam(@RequestParam(name = "prodId") String name,
                                                    @RequestParam(name = "prodDesc") String pDesc,
                                                    @RequestParam(name = "catName") String cName ,
                                                    @RequestParam(name = "catDesc") String cDesc
    ){
        ProductDTO prodDto = new ProductDTO();
        CategoryDTO CatDTO = new CategoryDTO();
        Product prod = productServiceIMPL.createProductByReqParam(name,pDesc, cName, cDesc);
        prodDto.setName(prod.getName());
        prodDto.setDescription(prod.getDescription());
//        prodDto.getCategory().setDescription(prod.getCategory().getDesc());
//        prodDto.getCategory().setName(prod.getCategory().getName());
        CatDTO.setName(prod.getCategory().getName());
        CatDTO.setDescription(prod.getCategory().getDesc());
        prodDto.setCategory(CatDTO);
        prodDto.setCreatedDateTime(prod.getCreatedDateTime());
        return prodDto;
    }

    @PatchMapping("/Products/update/{uuid}")
    public ProductDTO updateProd(@RequestBody Product prod , @PathVariable UUID uuid){
        Product product = productServiceIMPL.updateProduct(prod, uuid);
        ProductDTO prodDto = new ProductDTO();
        CategoryDTO CatDTO = new CategoryDTO();
        prodDto.setName(product.getName());
        prodDto.setDescription(product.getDescription());
//        prodDto.getCategory().setDescription(prod.getCategory().getDesc());
//        prodDto.getCategory().setName(prod.getCategory().getName());
        CatDTO.setName(product.getCategory().getName());
        CatDTO.setDescription(product.getCategory().getDesc());
        prodDto.setCategory(CatDTO);
        prodDto.setCreatedDateTime(product.getCreatedDateTime());
        return prodDto;


    }

    @DeleteMapping("/Products/Delete/{uuid}")
    public String deleteProduct(@PathVariable UUID uuid){


        return productServiceIMPL.deleteProduct(uuid);
    }
}



//Create restapi's for the following:
//Get product by UUID using pathvariable                        DONE
//Get products with category phones, using request params,      DONE
//Create a new product with request params ,                    DONE
//update a product with id                                      DONE
//delete a product with id using path variable ,
//AddtoCart add a product to cart with request body



