package com.vieira.hexagonal.adapters.out;

import com.vieira.hexagonal.adapters.out.repository.CustomerRepository;
import com.vieira.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.vieira.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void updateCustomer(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.mapToCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
