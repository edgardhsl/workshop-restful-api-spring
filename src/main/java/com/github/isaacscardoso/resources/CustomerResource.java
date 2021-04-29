package com.github.isaacscardoso.resources;

import com.github.isaacscardoso.domain.Customer;
import com.github.isaacscardoso.dto.CustomerDTO;
import com.github.isaacscardoso.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("http://localhost:4200")
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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Validated CustomerDTO objDTO) {
        Customer obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Validated CustomerDTO objDTO, @PathVariable String id) {
        Customer obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
    }

}



