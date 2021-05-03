package com.github.isaacscardoso.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.isaacscardoso.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Document
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter@Setter
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Getter
    private Instant moment;

    private String orderStatus;

    @Getter@Setter
    private Customer client;

    // default constructor
    public Order() { }

    public Order(String id, OrderStatus orderStatus , Customer client) {
        this.id = id;
        this.moment = Instant.now();
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
