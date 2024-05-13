package com.vieira.hexagonal.application.core.usecase;

import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.vieira.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

import java.util.Optional;

public class FindCustomerByIdUserCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort customerByIdOutputPort;

    public FindCustomerByIdUserCase(FindCustomerByIdOutputPort customerByIdOutputPort) {
        this.customerByIdOutputPort = customerByIdOutputPort;
    }

    @Override
    public Customer findById(String id) {
        Optional<Customer> customerOpt = customerByIdOutputPort.findById(id);

        if (customerOpt.isEmpty()) {
            throw new RuntimeException("Customer is empty");
        }

        return customerOpt.get();
    }


}
