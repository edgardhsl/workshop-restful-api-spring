package com.github.isaacscardoso.services;

import com.github.isaacscardoso.domain.Category;
import com.github.isaacscardoso.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(String id) {
        return repository.findById(id).orElseThrow(
                () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category insert(Category obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }

    public void updateData(Category updatedObj, Category obj) {
        updatedObj.setName(obj.getName());
    }

    public Category update(Category obj) {
        Category updatedObj = findById(obj.getId());
        updateData(updatedObj, obj);
        return repository.save(updatedObj);
    }

}
