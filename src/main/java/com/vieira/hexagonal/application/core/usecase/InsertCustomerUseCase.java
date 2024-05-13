package com.vieira.hexagonal.application.core.usecase;

import com.vieira.hexagonal.application.core.domain.Address;
import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.vieira.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.vieira.hexagonal.application.ports.out.InsertCustumerOutport;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;
    private final InsertCustumerOutport insertCustumerOutport;

    public InsertCustomerUseCase(FindAddressByZipCodeOutPort findAddressByZipCodeOutPort, InsertCustumerOutport insertCustumerOutport) {
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.insertCustumerOutport = insertCustumerOutport;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address;
        address = findAddressByZipCodeOutPort.findAddresByZipcode(zipCode);

        customer.setAddress(address);

        insertCustumerOutport.insert(customer);
    }


}
