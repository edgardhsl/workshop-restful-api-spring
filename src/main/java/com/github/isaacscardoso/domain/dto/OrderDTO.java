package com.github.isaacscardoso.domain.dto;

import com.github.isaacscardoso.domain.Order;
import com.github.isaacscardoso.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter@Setter
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Instant moment;
    private OrderStatus orderStatus;

    public OrderDTO() { }

    public OrderDTO(Order obj) {
        this.id = obj.getId();
        this.moment = obj.getMoment();
        this.orderStatus = obj.getOrderStatus();
    }
}
