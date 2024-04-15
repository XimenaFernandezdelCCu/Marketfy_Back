package com.Marketfy.Server_Marketfy.repos;

import com.Marketfy.Server_Marketfy.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findByUserId(Integer userId);

}
