package com.Marketfy.Server_Marketfy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users_extra")
public class UsersExtra {
    @Id
    private int userId;
    private String preferred;
    private String bio;
    @Column(columnDefinition = "json")
    private String tags;
}
