package com.vieira.hexagonal.adapters.out.repository.mapper;

import com.vieira.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.vieira.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity mapToCustomerEntity(Customer customer);

    Customer mapToCustomer(CustomerEntity customerEntity);

}
