package com.Marketfy.Server_Marketfy.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Object getUserOrders(Integer userId);
}
