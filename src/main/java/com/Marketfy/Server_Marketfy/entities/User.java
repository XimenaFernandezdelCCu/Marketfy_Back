package com.Marketfy.Server_Marketfy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(unique = true)
    private String email;
    private String pass;
    private String first;
    private String last;
    private String role;
    private boolean active;

//    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
//    private List<WishlistItem> wishlistItems = new ArrayList<>();
}
