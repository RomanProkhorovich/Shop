package com.example.shop.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private Set<Storage> storages = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
