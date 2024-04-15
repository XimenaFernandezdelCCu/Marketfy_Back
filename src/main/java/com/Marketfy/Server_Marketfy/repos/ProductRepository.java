package com.Marketfy.Server_Marketfy.repos;

import com.Marketfy.Server_Marketfy.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product>findAll();



    @Override
    Optional<Product> findById(Integer integer);


//    @Query(value = "SELECT * FROM products WHERE product_id IN (:ids)")
//    List<Product> findProductByIdList(@Param("ids") List<Integer> ids);
    @Query("SELECT p FROM Product p WHERE p.productId IN :ids")
    List<Product> findProductByIdList(@Param("ids") List<Integer> ids);
}
