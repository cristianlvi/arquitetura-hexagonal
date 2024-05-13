package com.vieira.hexagonal.application.ports.out;

import com.vieira.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);

}
