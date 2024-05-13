package com.vieira.hexagonal.application.core.usecase;

import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.vieira.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.vieira.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void deleteCustomerById(String id) {
        Customer customer = findCustomerByIdInputPort.findById(id);

        deleteCustomerByIdOutputPort.deleteCustomerById(customer.getId());

    }


}
