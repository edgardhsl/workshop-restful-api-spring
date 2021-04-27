package com.github.isaacscardoso.services;

import com.github.isaacscardoso.domain.Customer;
import com.github.isaacscardoso.dto.CustomerDTO;
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

    public Customer fromDTO(CustomerDTO objDTO) {
        return new Customer(
                objDTO.getId(), objDTO.getName(), objDTO.getCpf(),
                objDTO.getBirthday(), objDTO.getEmail(), objDTO.getPhone()
        );
    }
}
