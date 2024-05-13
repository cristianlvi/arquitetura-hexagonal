package com.vieira.hexagonal.application.ports.in;

import com.vieira.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipcode);

}
