package com.Marketfy.Server_Marketfy.controllers;

import com.Marketfy.Server_Marketfy.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemsController {
    @Autowired
    OrderItemsService  service;

    @PostMapping("/AddOrderItems")
    public ResponseEntity<Object> AddOrderItems(@RequestBody Map<String, Object> itemObj ){
        return service.saveMultipleOrderItems(itemObj);
    }
}
