package com.Marketfy.Server_Marketfy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int productId;
    private String title;
    private String author;
    private double price;
    @Lob
    private byte[] image;
    private String synopsis;
    private int inventory;

//    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
//    private List<WishlistItem> wishlistItems = new ArrayList<>();

}
