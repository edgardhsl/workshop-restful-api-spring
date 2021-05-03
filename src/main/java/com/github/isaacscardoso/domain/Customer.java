package com.github.isaacscardoso.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.isaacscardoso.validation.ContactNumberConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
@Getter
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    public Instant registrationDate;

    @NotEmpty(message = "{field.name.mandatory}")
    @Setter
    private String name;

    @CPF(message = "{field.cpf.invalid}")
    @NotNull(message = "{field.cpf.mandatory}")
    @Setter
    private String cpf;

    @NotEmpty(message = "{field.birthday.mandatory}")
    @Setter
    private String birthday;

    @Email(message = "{field.email.mandatory}")
    @Setter
    private String email;

    @ContactNumberConstraint
    @Setter
    private String phone;

    private List<Order> orders;

    // default constructor
    public Customer() { }

    public Customer(String id, String name, String cpf, String birthday, String email, String phone) {
        this.id = id;
        this.registrationDate = Instant.now();
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
