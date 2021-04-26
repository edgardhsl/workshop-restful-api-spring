package com.github.isaacscardoso;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class WorkshopApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(WorkshopApplication.class, args);
        } catch (BeanCreationException e) {
            throw new BeanCreationException(Objects.requireNonNull(e.getBeanName()) + "\n.: " + e.getMessage());
        }
    }
}
