package com.github.isaacscardoso.dto;

import com.github.isaacscardoso.domain.Customer;

import com.github.isaacscardoso.validation.ContactNumberConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Getter@Setter
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotEmpty(message = "{field.name.mandatory}")
    private String name;

    @CPF(message = "{field.cpf.invalid}")
    @NotNull(message = "{field.cpf.mandatory}")
    private String cpf;

    @NotEmpty(message = "{field.birthday.mandatory}")
    private String birthday;

    @Email(message = "{field.email.invalid}")
    @NotEmpty(message = "{field.email.mandatory}")
    private String email;

    @ContactNumberConstraint
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
