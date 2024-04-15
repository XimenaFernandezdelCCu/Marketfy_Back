package com.Marketfy.Server_Marketfy.repos;

import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.entities.User;
import com.Marketfy.Server_Marketfy.entities.WishlistItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends CrudRepository<WishlistItem, Integer> {
//    List<WishlistItem> findByUser(User user);

//    @Query(value = "SELECT product_id FROM wishlist_items WHERE user_id = :userId", nativeQuery = true)


//    @Query(value = "SELECT p.* FROM products p INNER JOIN wishlist_items w ON p.product_id = w.product_id " +
//            "WHERE w.user_id = :userId", nativeQuery = true)
//    List<Object[]> findOrderByUserId(@Param("userId") Integer userId);
//    @Query(value = "SELECT product_id FROM wishlist_items WHERE user_id = :userId")
//    List<Integer> findProductIdsByUserId(@Param("userId") Integer userId);

    @Query("SELECT wi.wishlistId, wi.productId FROM WishlistItem wi WHERE wi.userId = :userId")
    List<Object[]> findProductIdsByUserId(@Param("userId") Integer userId);



}
