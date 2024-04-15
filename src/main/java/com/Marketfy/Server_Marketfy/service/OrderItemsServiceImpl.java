package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.*;
import com.Marketfy.Server_Marketfy.repos.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    OrderItemsRepository repository;

    @Override
    public ResponseEntity<Object> saveMultipleOrderItems(Map<String, Object> itemObj){

//        try {
            String OrderId = (String) itemObj.get("orderId");
            Integer OrderIdInt = Integer.valueOf(OrderId);
//            Integer OrderIdInt = (Integer) itemObj.get("orderId");

            List<Map<String, Integer>> itemList = (List<Map<String, Integer>>) itemObj.get("items");

            for (Map<String, Integer> item : itemList) {
                Integer newItemProductId = item.get("productId");
                Integer newItemQty = item.get("qty");
                OrderItems newItem = new OrderItems();
                newItem.setOrderId(OrderIdInt);
                newItem.setProductId(newItemProductId);
                newItem.setQty(newItemQty);
                repository.save(newItem);
            }

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Items Added to Order.");
//        } catch (Exception e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Error: " + e.getMessage());
//
//        }
    }


}
