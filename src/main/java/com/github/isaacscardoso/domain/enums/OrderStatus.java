package com.github.isaacscardoso.domain.enums;

import lombok.Getter;

public enum OrderStatus {
    WAITING_PAYMENT("WAITING PAYMENT"),
    PAID("PAID"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED"),
    CANCELED("CANCELED");

    @Getter
    private final String code;

    OrderStatus(String code) {
        this.code = code;
    }

    public static OrderStatus fromValue(String code) {
        if (code != null) {
            for (OrderStatus value : values()) {
                if (value.getCode().equals(code)) {
                    return value;
                }
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code.");
    }
}
