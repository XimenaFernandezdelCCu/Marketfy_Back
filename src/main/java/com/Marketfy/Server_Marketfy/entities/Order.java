package com.Marketfy.Server_Marketfy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int userId;
    private int totalItems;
    private double total;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date orderDate;
}
