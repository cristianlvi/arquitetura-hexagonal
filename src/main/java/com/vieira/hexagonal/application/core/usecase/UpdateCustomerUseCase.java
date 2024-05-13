package com.vieira.hexagonal.application.core.usecase;

import com.vieira.hexagonal.application.core.domain.Address;
import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.vieira.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.vieira.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.vieira.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }


    @Override
    public void updateCustomer(Customer customer, String zipcode) {
        findCustomerByIdInputPort.findById(customer.getId());
        Address address = findAddressByZipCodeOutPort.findAddresByZipcode(zipcode);

        customer.setAddress(address);

        updateCustomerOutputPort.updateCustomer(customer);
    }

}
