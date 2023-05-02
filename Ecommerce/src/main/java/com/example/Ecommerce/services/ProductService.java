package com.example.Ecommerce.services;

import com.example.Ecommerce.models.Product;
import com.example.Ecommerce.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;


    public List<Product> getAllProduct(){
        return productDao.getAll();
    }

    public Product getProductById(String id) {
        List<Product> item=productDao.getAll();
        for(Product product:item){
            if(product.getProductId()==Integer.parseInt(id)){
                return product;
            }
        }
        return null;
    }

    public Product getProductByCategory(String category) {
        List<Product> item=productDao.getAll();
        for(Product product:item){
            if(product.getCategory().equals(category)){
                return product;
            }
        }
        return null;
    }

    public String addProduct(Product item){
        if(item!=null){
            productDao.addItem(item);
            return "Product added successfully..!";
        }
        return "Invalid User input..!";
    }

    public String removeProduct(Product item){
        List<Product> products=productDao.getAll();
        for(Product itm:products){
            if(itm.getProductId()==item.getProductId()){
                productDao.deleteItem(item);
                return "Product Deleted...";
            }
        }
        return "Invalid user input..!";
    }
}
