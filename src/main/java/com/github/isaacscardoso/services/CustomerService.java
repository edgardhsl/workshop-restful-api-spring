package com.github.isaacscardoso.services;

import com.github.isaacscardoso.domain.Customer;
import com.github.isaacscardoso.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
    }

    public Customer insert(Customer obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }

    private void updateData(Customer updatedObj, Customer obj) {
        updatedObj.setName(obj.getName());
        updatedObj.setCpf(obj.getCpf());
        updatedObj.setBirthday(obj.getBirthday());
        updatedObj.setEmail(obj.getEmail());
        updatedObj.setPhone(obj.getPhone());
    }

    public Customer update(Customer obj) {
        Customer updatedObj = findById(obj.getId());
        updateData(updatedObj, obj);
        return repository.save(updatedObj);
    }

}
