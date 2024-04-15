package com.Marketfy.Server_Marketfy.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistItemDTO {
    private int wishlistId;
    private Product product;
    public WishlistItemDTO(int wishlistId, Product product) {
        this.wishlistId = wishlistId;
        this.product = product;
    }

}
