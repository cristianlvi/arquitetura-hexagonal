package com.vieira.hexagonal.adapters.out;

import com.vieira.hexagonal.adapters.out.repository.CustomerRepository;
import com.vieira.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.vieira.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;


    @Override
    public Optional<Customer> findById(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

        return customerEntity.map(entity -> customerEntityMapper.mapToCustomer(entity));
    }
}
