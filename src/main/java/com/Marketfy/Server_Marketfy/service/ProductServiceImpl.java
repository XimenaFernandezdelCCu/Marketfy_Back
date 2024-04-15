package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getUsersByIDArray(Integer[] ids){
        List<Product> products = new ArrayList<>();

        for (Integer id : ids) {
            Optional<Product> optionalProduct = repository.findById(id);
            optionalProduct.ifPresent(products::add);
        }
        return products;
    }
}
