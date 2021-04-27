package com.github.isaacscardoso.resources;

import com.github.isaacscardoso.domain.Customer;
import com.github.isaacscardoso.dto.CustomerDTO;
import com.github.isaacscardoso.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerResource {

    private final CustomerService service;

    @Autowired
    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> findAll() {
        List<Customer> customers = service.findAll();
        return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO findById(@PathVariable String id) {
        Customer obj = service.findById(id);
        return new CustomerDTO(obj);
    }
}



