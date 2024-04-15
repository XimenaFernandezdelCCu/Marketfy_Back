package com.Marketfy.Server_Marketfy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface OrderItemsService {
    ResponseEntity<Object> saveMultipleOrderItems(Map<String, Object> itemObj);
}
