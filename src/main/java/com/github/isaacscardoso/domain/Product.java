package com.github.isaacscardoso.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document
@Getter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    private String id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Double price;

    @Setter
    private String imgUrl;

    private Set<Category> categories;

    // default constructor
    public Product() { }

    public Product(String id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
