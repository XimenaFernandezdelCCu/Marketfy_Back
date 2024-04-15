package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.Order;
import com.Marketfy.Server_Marketfy.entities.OrderItems;
import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.repos.OrderItemsRepository;
import com.Marketfy.Server_Marketfy.repos.OrderRepository;
import com.Marketfy.Server_Marketfy.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemsRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Object getUserOrders(Integer userId) {
        // Retrieve orders for the given user
        List<Order> userOrders = orderRepository.findByUserId(userId);

        List<Object> formattedOrders = new ArrayList<>();

        for (Order order : userOrders) {
            // Retrieve order items for each order
            List<OrderItems> orderItems = orderItemRepository.findByOrderId(order.getOrderId());

            // Retrieve product details for each order item
            List<Object> products = new ArrayList<>();
            for (OrderItems orderItem : orderItems) {
                Product product = productRepository.findById(orderItem.getProductId()).orElse(null);
                if (product != null) {
                    // Create a product object with required fields
                    Map<String, Object> productInfo = new HashMap<>();
                    productInfo.put("productId", product.getProductId());
                    productInfo.put("author", product.getAuthor());
                    productInfo.put("title", product.getTitle());
                    productInfo.put("qty", orderItem.getQty());
                    products.add(productInfo);
                }
            }

            if (!products.isEmpty()) {
                // Create an order object with required fields
                Map<String, Object> formattedOrder = new HashMap<>();
                formattedOrder.put("orderId", order.getOrderId());
                formattedOrder.put("totalItems", order.getTotalItems());
                formattedOrder.put("total", order.getTotal());
                formattedOrder.put("date", order.getOrderDate());
                formattedOrder.put("products", products);

                formattedOrders.add(formattedOrder);
            } else {
                // Delete the order if it has no associated products
                orderRepository.delete(order);
            }


        }

        // Create the final object with userOrders and orders
        Map<String, Object> result = new HashMap<>();
        result.put("userOrders", formattedOrders.size());
        result.put("orders", formattedOrders);

        return result;
    }
}
