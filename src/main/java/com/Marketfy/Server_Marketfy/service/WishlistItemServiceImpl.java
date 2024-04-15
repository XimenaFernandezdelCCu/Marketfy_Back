package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.entities.User;
import com.Marketfy.Server_Marketfy.entities.WishlistItem;
import com.Marketfy.Server_Marketfy.entities.WishlistItemDTO;
import com.Marketfy.Server_Marketfy.repos.ProductRepository;
import com.Marketfy.Server_Marketfy.repos.UserRepository;
import com.Marketfy.Server_Marketfy.repos.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistItemServiceImpl implements WishlistItemService {
    @Autowired
    WishlistItemRepository repository;
    @Autowired
    ProductRepository productRepo;


//    @Override
//    public List<WishlistItem> getWishlistItemsByUser(Integer id){
//        Optional<User> userOptional = userRepo.findById(id);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            return repository.findByUser(user);
//        } else {
//            return Collections.emptyList();
//        }
//    }
//    @Override
//    public List<Product> getProductsinWishlistByUserId(Integer id){
//        List<Object[]> WishlistIdAndProductIdList = repository.findProductIdsByUserId(id);
//        List<Integer> productIds = new ArrayList<>();
//        List<Integer> wishlistIds = new ArrayList<>();
//        for (Object[] result : WishlistIdAndProductIdList) {
//            Integer productId = (Integer) result[1];
//            Integer wishlistId = (Integer) result[1];
//            productIds.add(productId);
//            wishlistIds.add(wishlistId);
//        }
//        List<Product> productList = productRepo.findProductByIdList(productIds);
//        List<Object[]> wishlistIdAndProduct = new ArrayList<>();
//        for (Integer id : wishlistIds ){
//            wishlistIdAndProduct.add()
//
//
//        }
//        return
//    }
@Override
public List<WishlistItemDTO> getProductsinWishlistByUserId(Integer id){
    List<Object[]> wishlistIdAndProductIdList = repository.findProductIdsByUserId(id);
    List<WishlistItemDTO> wishlistItems = new ArrayList<>();

    for (Object[] result : wishlistIdAndProductIdList) {
        Integer wishlistId = (Integer) result[0];
        Integer productId = (Integer) result[1];

        Product product = productRepo.findById(productId).orElse(null);
        if (product != null) {
            WishlistItemDTO wishlistItem = new WishlistItemDTO(wishlistId, product);
            wishlistItems.add(wishlistItem);
        }
    }

    return wishlistItems;
}

}
