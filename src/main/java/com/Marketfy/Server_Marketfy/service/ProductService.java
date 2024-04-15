package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getUsersByIDArray(Integer[] ids);
}
