package com.vieira.hexagonal.application.ports.in;

import com.vieira.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void updateCustomer(Customer customer, String zipcode);

}
