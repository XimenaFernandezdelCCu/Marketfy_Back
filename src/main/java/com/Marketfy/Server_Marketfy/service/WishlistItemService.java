package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.Product;
import com.Marketfy.Server_Marketfy.entities.User;
import com.Marketfy.Server_Marketfy.entities.WishlistItem;
import com.Marketfy.Server_Marketfy.entities.WishlistItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishlistItemService {
//    List<WishlistItem> getWishlistItemsByUser(Integer id);

    List<WishlistItemDTO> getProductsinWishlistByUserId(Integer id);
}
