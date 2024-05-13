package com.vieira.hexagonal.application.ports.out;

import com.vieira.hexagonal.application.core.domain.Customer;

public interface InsertCustumerOutport {

    void insert(Customer customer);

}
