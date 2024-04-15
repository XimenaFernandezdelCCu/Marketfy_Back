package com.Marketfy.Server_Marketfy.controllers;

import com.Marketfy.Server_Marketfy.entities.WishlistItemDTO;
import com.Marketfy.Server_Marketfy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping("/ordersByUserId")
    public ResponseEntity<Object> ordersByUserId(@RequestParam Integer userId){
        Object orders = service.getUserOrders(userId);
        if (orders==null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No user orders");
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(orders);
        }
    }
}
