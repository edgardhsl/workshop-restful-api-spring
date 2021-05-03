package com.github.isaacscardoso.services;

import com.github.isaacscardoso.domain.Order;
import com.github.isaacscardoso.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public Order insert(Order obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }

    public void updateData(Order updatedObj, Order obj) {
        updatedObj.setOrderStatus(obj.getOrderStatus());
        updatedObj.setClient(obj.getClient());
    }

    public Order update(Order obj) {
        Order updatedObj = findById(obj.getId());
        updateData(updatedObj, obj);
        return repository.save(updatedObj);
    }
}
