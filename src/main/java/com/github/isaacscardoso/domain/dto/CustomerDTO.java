package com.github.isaacscardoso.domain.dto;

import com.github.isaacscardoso.domain.Customer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter
public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String cpf;
    private String birthday;
    private String email;
    private String phone;

    public CustomerDTO() { }

    public CustomerDTO(Customer obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.birthday = obj.getBirthday();
        this.email = obj.getEmail();
        this.phone = obj.getPhone();
    }
}
