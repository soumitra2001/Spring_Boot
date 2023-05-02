package com.example.Ecommerce.controllers;

import com.example.Ecommerce.models.Product;
import com.example.Ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/all")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductById(id);
    }

    @RequestMapping(value="/by",method = RequestMethod.GET)
    public Product getCategoryProduct(@RequestParam String category){
        return productService.getProductByCategory(category);
    }

    @PostMapping(value = "/one")
    public String addProduct(@RequestBody Product item){
        return productService.addProduct(item);
    }

    @DeleteMapping
    public String deleteProduct(@RequestBody Product item){
        return productService.removeProduct(item);
    }
}
