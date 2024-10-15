package com.cogent.week5.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name ="categories"
)
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private  String name;
    @OneToMany(
            mappedBy = "category",
            cascade =  CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Product> products = new HashSet<>();


}
