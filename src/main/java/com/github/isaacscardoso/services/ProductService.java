package com.github.isaacscardoso.services;

import com.github.isaacscardoso.domain.Product;
import com.github.isaacscardoso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found."));
    }

    public Product insert(Product obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }

    public void updateData(Product updatedObj, Product obj) {
        updatedObj.setName(obj.getName());
        updatedObj.setDescription(obj.getDescription());
        updatedObj.setPrice(obj.getPrice());
        updatedObj.setImgUrl(obj.getImgUrl());
    }

    public Product update(Product obj) {
        Product updatedObj = findById(obj.getId());
        updateData(updatedObj, obj);
        return repository.save(updatedObj);
    }
}
