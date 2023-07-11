package com.example.shop.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(unique = true,nullable = false)
    private String city;


    @NonNull
    @Column(unique = true,nullable = false)
    private String street;


    @NonNull
    @Column(unique = true,nullable = false)
    private Integer houseNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return id.equals(storage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
