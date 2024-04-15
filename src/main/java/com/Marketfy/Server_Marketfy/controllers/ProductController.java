package com.Marketfy.Server_Marketfy.controllers;

import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.repos.ProductRepository;
import com.Marketfy.Server_Marketfy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = repository.findAll();
        if (!products.isEmpty()){
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(products, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/byIDs")
    public ResponseEntity<List<Product>> getProductsByID(@RequestParam List<Integer> ids){

        List<Product> products = service.getUsersByIDArray(ids.toArray(new Integer[0]));
        if (!products.isEmpty()){
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(products, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/products/byIds")
//    public ResponseEntity<List<Product>> getProductsbyID(@RequestParam List<Integer> ids){
//        List<Product> products = repository.findAllByIdIn(ids);
//        if (!products.isEmpty()){
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(products, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
