package com.vieira.hexagonal.adapters.in.controller.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CustomerRequest {
    @NotBlank
    private String name;

    @CPF
    private String cpf;

    @NotBlank
    private String zipcode;

}
