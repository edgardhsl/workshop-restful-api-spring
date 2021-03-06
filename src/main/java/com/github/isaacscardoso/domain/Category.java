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
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    private String id;

    @Setter
    private String name;

    private Set<Product> products;

    // default constructor
    public Category() { }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
        this.products = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
