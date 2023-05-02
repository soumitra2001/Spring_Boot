package com.example.Ecommerce.repositories;

import com.example.Ecommerce.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    private List<Product> products;

    public ProductDao(){
        products=new ArrayList<>();
        products.add(new Product(0,"T-shirt",500.0,"Fashion"));
    }

    public List<Product> getAll(){
        return products;
    }

    public void addItem(Product item) {
        products.add(item);
    }

    public void deleteItem(Product item){
        for(int i=0;i<products.size();i++){
            if(item.getProductId()==products.get(i).getProductId())products.remove(i);
        }
    }
}
