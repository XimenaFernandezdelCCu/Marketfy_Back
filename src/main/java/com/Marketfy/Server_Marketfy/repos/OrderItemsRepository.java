package com.Marketfy.Server_Marketfy.repos;

import com.Marketfy.Server_Marketfy.entities.OrderItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {
    List<OrderItems> findByOrderId(Integer orderId);

}
