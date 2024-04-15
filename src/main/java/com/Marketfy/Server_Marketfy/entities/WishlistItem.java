package com.Marketfy.Server_Marketfy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="wishlist_items")
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private Integer userId;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
    private Integer productId;
}
