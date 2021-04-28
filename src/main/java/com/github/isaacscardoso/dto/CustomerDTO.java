package com.github.isaacscardoso.dto;

import com.github.isaacscardoso.domain.Customer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter@Setter
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String cpf;
    private String birthday;
    private String email;
    private String phone;
    public Instant registrationDate;

    public CustomerDTO() { }

    public CustomerDTO(Customer obj) {
        id = obj.getId();
        name = obj.getName();
        cpf = obj.getCpf();
        birthday = obj.getBirthday();
        email = obj.getEmail();
        phone = obj.getPhone();
        registrationDate = obj.getRegistrationDate();
    }
}
