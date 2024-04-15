package com.Marketfy.Server_Marketfy.controllers;

import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.entities.User;
import com.Marketfy.Server_Marketfy.entities.WishlistItem;
import com.Marketfy.Server_Marketfy.entities.WishlistItemDTO;
import com.Marketfy.Server_Marketfy.repos.UserRepository;
import com.Marketfy.Server_Marketfy.repos.WishlistItemRepository;
import com.Marketfy.Server_Marketfy.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WishlistItemsController {

    @Autowired
    WishlistItemService service;
    @Autowired
    WishlistItemRepository repository;
    @Autowired
    UserRepository userRepo;

//    @GetMapping("/productsInWishlistByUserId")
//    public ResponseEntity<Object> getProductsInWishlistByUserId(@RequestParam Integer id){
//        List<Product> products = service.getProductsinWishlistByUserId(id);
//        if (products.isEmpty()){
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("No products in this user's wishlist");
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(products);
//        }
//    }
@GetMapping("/productsInWishlistByUserId")
public ResponseEntity<Object> getProductsInWishlistByUserId(@RequestParam Integer id){
    List<WishlistItemDTO> products = service.getProductsinWishlistByUserId(id);
    if (products.isEmpty()){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("No products in this user's wishlist");
    } else {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }
}

//    @GetMapping("/wishlistByUser")
//    public ResponseEntity<Object> getWishlistItemsByUser2(@RequestParam Integer id){
//        Optional<User> userOptional = userRepo.findById(id);
//        if (userOptional.isPresent()) {
//            List<Object[]> myList = repository.findOrderByUserId(id);
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(myList);
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("No user found");
//        }
//    }

    @PostMapping("/AddWishlistItem")
    public ResponseEntity<Object> addWishlistItem(@RequestParam Map<String, Object> listItem){
        return null;
    }







//    @GetMapping("/wishlistByUser")
//    public ResponseEntity<Object> getWishlistItemsByUser(@RequestParam Integer id){
//        List<WishlistItem> wishList = service.getWishlistItemsByUser(id);
//        if(wishList.isEmpty()){
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("No user found");
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(wishList);
//
//        }
//
//
//    }






}
