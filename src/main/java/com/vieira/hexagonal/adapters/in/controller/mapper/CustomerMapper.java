package com.vieira.hexagonal.adapters.in.controller.mapper;

import com.vieira.hexagonal.adapters.in.controller.Request.CustomerRequest;
import com.vieira.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.vieira.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer mapToCustomer(CustomerRequest customerRequest);


    CustomerResponse mapToCustomerResponse(Customer customer);

}
