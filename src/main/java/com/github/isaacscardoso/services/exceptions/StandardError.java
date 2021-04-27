package com.github.isaacscardoso.services.exceptions;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class StandardError {

    @Getter
    private final List<String> errors;

    public StandardError(List<String> errors) {
        this.errors = errors;
    }

    public StandardError(String message) {
        this.errors = Collections.singletonList(message);
    }
}
