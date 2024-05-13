package com.vieira.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private String cpf;

    private AddressResponse address;

    private Boolean isValidCpf;


}
